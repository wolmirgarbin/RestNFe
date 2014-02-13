package br.com.jtron.restnfe.dto;

public class Imposto {
	
	//vseg
	private String seguro;	
	//vOutro
	private String outros;	
	//vFrete
	private String frete;	
	//vDesc
	private String desconto;	
	//vIPI
	private String ipi;	
	//vNF
	private String valorTotal;	
	//vBC
	private String baseICMS;	
	//vICMS
	private String valorICMS;	
	//vBCST
	private String baseST;	
	//vST
	private String subICMS;	
	//vProd
	private String valorProdutos;
	
	
	public String getSeguro() {
		return seguro;
	}
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	public String getOutros() {
		return outros;
	}
	public void setOutros(String outros) {
		this.outros = outros;
	}
	public String getFrete() {
		return frete;
	}
	public void setFrete(String frete) {
		this.frete = frete;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getIpi() {
		return ipi;
	}
	public void setIpi(String ipi) {
		this.ipi = ipi;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getBaseICMS() {
		return baseICMS;
	}
	public void setBaseICMS(String baseICMS) {
		this.baseICMS = baseICMS;
	}
	public String getValorICMS() {
		return valorICMS;
	}
	public void setValorICMS(String valorICMS) {
		this.valorICMS = valorICMS;
	}
	public String getBaseST() {
		return baseST;
	}
	public void setBaseST(String baseST) {
		this.baseST = baseST;
	}
	public String getSubICMS() {
		return subICMS;
	}
	public void setSubICMS(String subICMS) {
		this.subICMS = subICMS;
	}
	public String getValorProdutos() {
		return valorProdutos;
	}
	public void setValorProdutos(String valorProdutos) {
		this.valorProdutos = valorProdutos;
	}
	
}