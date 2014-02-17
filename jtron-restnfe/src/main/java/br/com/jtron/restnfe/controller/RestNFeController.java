package br.com.jtron.restnfe.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.download.ByteArrayDownload;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.view.Results;
import br.com.jtron.restnfe.cert.AssinadorA1;
import br.com.jtron.restnfe.cert.AutenticadorCert;
import br.com.jtron.restnfe.dao.EmpresaDAO;
import br.com.jtron.restnfe.dao.NFeDAO;
import br.com.jtron.restnfe.dto.Empresa;
import br.com.jtron.restnfe.sefaz.URLSefazConsultaSituacao;
import br.com.jtron.restnfe.sefaz.URLSefazNFeRecepcao;
import br.com.jtron.restnfe.sefaz.URLSefazNFeRetorno;
import br.com.jtron.restnfe.util.ChaveAcessoNFe;
import br.com.jtron.restnfe.util.EditaXMLNFe;
import br.com.jtron.restnfe.util.PropertiesHelper;
import br.com.jtron.restnfe.util.XmlUtil;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.ConsultaProtocoloService;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2.NFeEmissaoService;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetEmissaoService;

@Resource
public class RestNFeController {

	private final Result result;
		
	public RestNFeController(Result result) {
		this.result = result;
	}	
	
	/*@Path("/nfe/consultarServico/{ambiente}/{chave}")
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
		
	}*/
	
	/**
	 * Consultar procotolo de uma NFe no ambiente SEFAZ.
	 * Este serviço identifica o estado da emissão da nota pela chave
	 * e faz a consulta no ambiente de SEFAZ correspondente.
	 * @param ambiente
	 * @param chave
	 */
	@Path("/nfe/consultar/protocolo/{ambiente}/{chave}")
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
	
	/**
	 *
	 * Gerar chave para NFe.
	 * O processo de geração de chave é complicado e para abstrarir esta complexidade
	 * esta api permite a abstração do mesmo.
	 * 
	 * @GET
	 * @param cUF
	 * @param cnpj
	 * @param serie
	 * @param nNf
	 */
	/*@Path("/nfe/gerar/chave/{cUF}/{cnpj}/{serie}/{nNf}")
	public void gerarChave(String cUF,String cnpj,String serie,String nNf){		
		ChaveAcessoNFe chaveAcessoNFe = new ChaveAcessoNFe();
		try{			
			String retorno = chaveAcessoNFe.gerarChave(cUF, cnpj, serie, nNf);
			result.use(Results.xml()).from(retorno).serialize();			
		}catch(Exception e){
			result.use(Results.xml()).from(e.getCause()).serialize();
		}
	}*/
	
	
	/**
	 * 
	 * Emissão de NFe. Uma vez gerado o XML com a chave correta basta passar para 
	 * este rest e a emissão é feita e validada. Caso sucesso tudo é armazenado e 
	 * protocoloado para garantir validade juridica. Caso erro o mesmo é retornado
	 * para tratamento. 
	 * 
	 * @param xml
	 * @param ambiente
	 * @param nota
	 * @param serie	
	 */
	@Path("/nfe/emitir")
	public void emitirNFe(String xml,String ambiente,String nota,String serie){
		
		try {
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			Empresa empresa = empresaDAO.obterEmpresaUnica();
			
			ChaveAcessoNFe chaveAcessoNFe = new ChaveAcessoNFe();	
			String chave = chaveAcessoNFe.gerarChave(empresa.getCodEstado(), empresa.getCnpj(), serie, nota);			
			char dv = chave.charAt(46);
			String nf = chave.substring(38, 46);			
			xml = EditaXMLNFe.alteraXML(xml, chave, String.valueOf(dv), nf, nota, ambiente,serie);		
			//TNFe nfe = XmlUtil.lerDownload(ResultSEFAZUtil.lerXMLNfeDownload(xml));								 									
			String certificado = PropertiesHelper.getInstance().getKey("certificado");
	        String senha  = PropertiesHelper.getInstance().getKey("senha");        
	        xml = AssinadorA1.assinar(xml,certificado,senha);        
	        NFeEmissaoService nFeEmissaoService = new NFeEmissaoService();
	        
	        InputStream in = new FileInputStream(certificado);
	        AutenticadorCert autenticadorCert = new AutenticadorCert();            
            autenticadorCert.preparaAmbiente(in, senha.toCharArray());
            
	        String url = URLSefazNFeRecepcao.getURLPorUF(Integer.valueOf(empresa.getCodEstado()), Integer.valueOf(ambiente));
	        	        
	        String resultadoSEFAZ = nFeEmissaoService.emissao(xml, empresa.getCodEstado(), url);
	        
	        String protocolo = XmlUtil.lerPotocoloEnvioLoto(resultadoSEFAZ);
	        	        	        
	        boolean processando = true;								
			int status = 1;
			String retorno = null;					
			while(processando){		
				retorno = retornoEmissao(ambiente,protocolo,empresa.getCodEstado());
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
				nFeDAO.salvar(chave.replace("NFe", ""), xml,retorno,ambiente);						        
			}
			
			result.use(Results.xml()).from(retorno).serialize();
        
		} catch (Exception e) {
			e.printStackTrace();
			result.use(Results.xml()).from(e.getMessage()).serialize();
		}
		
	}
	
	
	/**
	 *
	 * Download do XML assinado digitalmente
	 * 
	 * @GET
	 * @param chave
	 * @return
	 */
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