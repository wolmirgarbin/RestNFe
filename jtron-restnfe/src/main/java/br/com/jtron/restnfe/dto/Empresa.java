package br.com.jtron.restnfe.dto;

/**
 * @author jose.pereira
 *
 */
public class Empresa {
	
	private String nome;
	private String cnpj;
	private String codEstado;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}
	
	
	
	
}
