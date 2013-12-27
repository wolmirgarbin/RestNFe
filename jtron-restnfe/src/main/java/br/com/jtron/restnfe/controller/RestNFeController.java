package br.com.jtron.restnfe.controller;

import java.io.FileInputStream;
import java.io.InputStream;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.jtron.restnfe.cert.AutenticadorCert;
import br.com.jtron.restnfe.sefaz.URLSefazConsultaStatus;
import br.com.jtron.restnfe.util.ChaveAcessoNFe;
import br.com.jtron.restnfe.util.PropertiesHelper;
import br.inf.portalfiscal.www.nfe.wsdl.nfeconsulta2.ConsultaProtocoloService;
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
	
}