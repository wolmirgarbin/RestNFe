package br.com.jtron.restnfe.dto;

public class Produto {
	
	private String descricao;
	private String codigo;
	private Integer quantiade;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getQuantiade() {
		return quantiade;
	}
	public void setQuantiade(Integer quantiade) {
		this.quantiade = quantiade;
	}	
	

}
