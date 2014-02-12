package br.com.jtron.restnfe.controller;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.jtron.restnfe.util.ChaveAcessoNFe;
import br.com.jtron.restnfe.util.EditaXMLNFe;

@Resource
public class RestNFeTestController {

	Result result;
	
	public RestNFeTestController(Result result) {
		this.result = result;
	}
	
	
	@Path("/teste/env/nfe")
	public void testEnvNFe(){
		
				
		try {
							
			String xml = readFile("C:\\Users\\jose.pereira\\Desktop\\33140217715809000100550010000000011597807407-nfe.xml", StandardCharsets.UTF_8);
			
			ChaveAcessoNFe chaveAcessoNFe = new ChaveAcessoNFe();		
			String chave = chaveAcessoNFe.gerarChave("33", "17715809000100", "1", "3");
			
			char dv = chave.charAt(46);
			String nf = chave.substring(38, 46); 
			
			xml = EditaXMLNFe.alteraXML(xml, chave, String.valueOf(dv), nf, 3, "2","1");
			
			result.redirectTo(RestNFeController.class).emitirNFe(xml, "2");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static String readFile(String path, Charset encoding) throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	
	
}
