package br.com.jtron.restnfe.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class SandboxController {

	Result result;
	
	public SandboxController(Result result) {
		this.result = result;
	}
	
	/**
	 * 
	 * Sandbox para teste das api´s rest
	 * 
	 * @GET
	 */
	@Path("/sandbox")
	public void sandbox(){			
		
	}
	
	@Path("/")
	public void doc(){
		
	}
		
}