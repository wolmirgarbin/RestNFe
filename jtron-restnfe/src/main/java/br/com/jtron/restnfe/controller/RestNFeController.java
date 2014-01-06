package br.com.jtron.restnfe.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.gko.entidade.envio.TNFe;
import br.com.jtron.restnfe.cert.AssinadorA1;
import br.com.jtron.restnfe.cert.AutenticadorCert;
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
            String urlStatus = URLSefazConsultaStatus.getURLPorUF(Integer.valueOf(estado),Integer.valueOf(ambiente));                        
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
	
	@Path("/nfe/gerarChave/")
	public void gerarChave(String cUF,String cnpj,String serie,String nNF){		
		ChaveAcessoNFe chaveAcessoNFe = new ChaveAcessoNFe();		
		result.use(Results.xml()).from(chaveAcessoNFe.gerarChave(cUF, cnpj, serie, nNF)).serialize();				
	}
	
	
	@Path("/nfe/emitirNFe/{ambiente}/{uf}")
	public void emitirNFe(String xml,String ambiente){
		
		try {
		
			TNFe nfe = lerDownload(ResultSEFAZUtil.lerXMLNfeDownload(xml));		
			
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
	        
	        result.use(Results.xml()).from(resultadoSEFAZ).serialize();
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Path("/nfe/retorno/{ambiente}/{protocolo}/{estado}")
	public void retornoEmissao(String ambiente, String protocolo,String estado){
		
		try {
		NfeRetEmissaoService retEmissaoService = new NfeRetEmissaoService();			
		
		String url = URLSefazNFeRetorno.getURLPorUF(Integer.valueOf(estado), Integer.valueOf(ambiente));
		
		String certificado = PropertiesHelper.getInstance().getKey("certificado");
        String senha  = PropertiesHelper.getInstance().getKey("senha");            
        InputStream in = new FileInputStream(certificado);		                        
        AutenticadorCert autenticadorCert = new AutenticadorCert();            
        autenticadorCert.preparaAmbiente(in, senha.toCharArray());     
		
		String retorno = retEmissaoService.obterRetornoEmissao(protocolo, url, ambiente, estado);
		
		result.use(Results.xml()).from(retorno).serialize();
		
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
	}
	
	
	private static TNFe lerDownload(String xml) throws Exception {  		
        TNFe nfe = null;		       	        	       
            if(xml!=null){                
                JAXBContext context;
                Unmarshaller unmarshaller;                       
                Matcher m = Pattern.compile("(?s)(?=<NFe).*?>.*?(?<=</NFe>)").matcher(xml);
                while(m.find()){            	                
                    String strNFe = m.group(0);            	            	
                    strNFe = strNFe.replace("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");            	            	
                    context = JAXBContext.newInstance(TNFe.class);    
                    unmarshaller = context.createUnmarshaller();                            
                    nfe = (TNFe) unmarshaller.unmarshal(new StringReader(strNFe));                            
                }         
            }            
        return nfe;
    }  
	
	
}