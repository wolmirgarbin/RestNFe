package br.com.jtron.restnfe.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.download.ByteArrayDownload;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.view.Results;
import br.com.jtron.restnfe.cert.AssinadorA1;
import br.com.jtron.restnfe.cert.AutenticadorCert;
import br.com.jtron.restnfe.dao.NFeDAO;
import br.com.jtron.restnfe.entidade.envio.TNFe;
import br.com.jtron.restnfe.sefaz.URLSefazConsultaSituacao;
import br.com.jtron.restnfe.sefaz.URLSefazConsultaStatus;
import br.com.jtron.restnfe.sefaz.URLSefazNFeRecepcao;
import br.com.jtron.restnfe.sefaz.URLSefazNFeRetorno;
import br.com.jtron.restnfe.util.ChaveAcessoNFe;
import br.com.jtron.restnfe.util.PropertiesHelper;
import br.com.jtron.restnfe.util.ResultSEFAZUtil;
import br.com.jtron.restnfe.util.XmlUtil;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.ConsultaProtocoloService;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2.NFeEmissaoService;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetEmissaoService;
import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.ConsultaService;

@Resource
public class RestNFeController {

	private final Result result;
		
	public RestNFeController(Result result) {
		this.result = result;
	}	
	
	@Path("/nfe/consultarServico/{ambiente}/{chave}")
	public void consultarServico(String ambiente,String chave){
		
		try {        	
        	String estado = chave.substring(0,2);                    
            String urlStatus = URLSefazConsultaStatus.getURLPorUF(Integer.valueOf(estado),Integer.valueOf(ambiente));                        
            String certificado = PropertiesHelper.getInstance().getKey("certificado");
            String senha  = PropertiesHelper.getInstance().getKey("senha");            
            InputStream in = new FileInputStream(certificado);                          
            AutenticadorCert autenticadorCert = new AutenticadorCert();            
            autenticadorCert.preparaAmbiente(in, senha.toCharArray());            
			String resultStatusSEFAZ = ConsultaService.consulta(chave, String.valueOf(ambiente),urlStatus);															
			result.use(Results.xml()).from(resultStatusSEFAZ).serialize();			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	@Path("/nfe/consultarProtocolo/{ambiente}/{chave}")
	public void consultarProtocolo(String ambiente,String chave){
		
		try {        	
        	String estado = chave.substring(0,2);                    
            String urlStatus = URLSefazConsultaSituacao.getURLPorUF(Integer.valueOf(estado),Integer.valueOf(ambiente));                        
            String certificado = PropertiesHelper.getInstance().getKey("certificado");
            String senha  = PropertiesHelper.getInstance().getKey("senha");            
            InputStream in = new FileInputStream(certificado);                          
            AutenticadorCert autenticadorCert = new AutenticadorCert();            
            autenticadorCert.preparaAmbiente(in, senha.toCharArray());            
			String resultStatusSEFAZ = ConsultaProtocoloService.consultaProtocolo(chave, String.valueOf(ambiente),urlStatus);															
			result.use(Results.xml()).from(resultStatusSEFAZ).serialize();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Path("/nfe/gerarChave/{cUF}/{cnpj}/{serie}/{nNf}")
	public void gerarChave(String cUF,String cnpj,String serie,String nNf){		
		ChaveAcessoNFe chaveAcessoNFe = new ChaveAcessoNFe();
		
		try{			
			String retorno = chaveAcessoNFe.gerarChave(cUF, cnpj, serie, nNf);
			result.use(Results.xml()).from(retorno).serialize();			
		}catch(Exception e){
			result.use(Results.xml()).from(e.getCause()).serialize();
		}
		
						
	}
	
	
	@Path("/nfe/emitir")
	public void emitirNFe(String xml,String ambiente){
		
		try {
		
			TNFe nfe = XmlUtil.lerDownload(ResultSEFAZUtil.lerXMLNfeDownload(xml));		
			
			String chave = nfe.getInfNFe().getId();
			String codigoEstado = chave.substring(3, 5);
			
			String certificado = PropertiesHelper.getInstance().getKey("certificado");
	        String senha  = PropertiesHelper.getInstance().getKey("senha");        
	        xml = AssinadorA1.assinar(xml,certificado,senha);        
	        NFeEmissaoService nFeEmissaoService = new NFeEmissaoService();
	        
	        InputStream in = new FileInputStream(certificado);
	        AutenticadorCert autenticadorCert = new AutenticadorCert();            
            autenticadorCert.preparaAmbiente(in, senha.toCharArray());
            
	        String url = URLSefazNFeRecepcao.getURLPorUF(Integer.valueOf(codigoEstado), Integer.valueOf(ambiente));
	        	        
	        String resultadoSEFAZ = nFeEmissaoService.emissao(xml, codigoEstado, url);
	        
	        String protocolo = XmlUtil.lerPotocoloEnvioLoto(resultadoSEFAZ);
	        	        	        
	        boolean processando = true;								
			int status = 1;
			String retorno = null;					
			while(processando){		
				retorno = retornoEmissao(ambiente,protocolo,codigoEstado);
				System.out.println(retorno);
				status = XmlUtil.lerStatusProcessamento(retorno);
				if(status!=105){
					processando = false;
					continue;
				}			
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
					result.use(Results.xml()).from(retorno).serialize();					
				}						
			}
	        	    
			if(status==100){						
				NFeDAO nFeDAO = new NFeDAO();
				nFeDAO.salvar(chave.replace("NFe", ""), xml,retorno);						        
			}
			
			result.use(Results.xml()).from(retorno).serialize();
        
		} catch (Exception e) {
			e.printStackTrace();
			result.use(Results.xml()).from(e.getMessage()).serialize();
		}
		
	}
	
	@Path("/nfe/download/xml/{chave}")
	public Download downloadXML(String chave){

		NFeDAO nFeDAO = new NFeDAO();
		
		String xml = nFeDAO.obterXmlPorChave(chave);
		
		try {
			return new ByteArrayDownload(xml.getBytes("UTF-8") , "application/octet-stream", "Evento_MDE-"+chave+".xml" );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/*@Path("/nfe/download/pdf/{chave}")
	public Download downloadPDF(String chave){

		NFeDAO nFeDAO = new NFeDAO();
		
		String xml = nFeDAO.obterXmlPorChave(chave);
		
		try {
			return new ByteArrayDownload(xml.getBytes("UTF-8") , "application/octet-stream", "Evento_MDE-"+chave+".xml" );			
			//OutputStream os = new FileOutputStream("C:\hello.pdf");  
			//Html2Pdf.convert("<h1 style=\"color:red\">Hello PDF</h1>", os);           
			//os.close();			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}*/
	
			
	public String retornoEmissao(String ambiente, String protocolo,String estado){
		
		try {
		NfeRetEmissaoService retEmissaoService = new NfeRetEmissaoService();			
		
		String url = URLSefazNFeRetorno.getURLPorUF(Integer.valueOf(estado), Integer.valueOf(ambiente));
		
		String certificado = PropertiesHelper.getInstance().getKey("certificado");
        String senha  = PropertiesHelper.getInstance().getKey("senha");            
        InputStream in = new FileInputStream(certificado);		                        
        AutenticadorCert autenticadorCert = new AutenticadorCert();            
        autenticadorCert.preparaAmbiente(in, senha.toCharArray());     
		
		String retorno = retEmissaoService.obterRetornoEmissao(protocolo, url, ambiente, estado);							
		
		return retorno;
		
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	  
	
}