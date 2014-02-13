package br.com.jtron.restnfe.dto;

import java.util.List;

public class NFe {
	
	
	private String chave;
	private String numeracao;
	private String serie;
	private String natureza;
	private String dataEmissao;
	private Destinatario destinatario;
	private Emitente emitente;
	private List<Produto> produtos;
	private Imposto imposto; 
		
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Destinatario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}
	public Emitente getEmitente() {
		return emitente;
	}
	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getNumeracao() {
		return numeracao;
	}
	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}
	public String getNatureza() {
		return natureza;
	}
	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	public Imposto getImposto() {
		return imposto;
	}
	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}	
	

}
