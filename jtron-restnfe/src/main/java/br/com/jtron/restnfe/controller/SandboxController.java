package br.com.jtron.restnfe.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class SandboxController {

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