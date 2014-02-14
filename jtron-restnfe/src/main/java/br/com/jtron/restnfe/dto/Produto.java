package br.com.jtron.restnfe.dto;

public class Produto {
	
	private String descricao;
	private String codigo;
	private Integer quantiade;
	
	//NCM
	private String ncm;
	//CST
	private String cst;
	//CFOP
	private String cfop;	
	//UN
	private String un; 
	//QUANT
	private String quant;
	//VLR. UNIT.
	private String vlrUnit;
	//VALOR TOTAL
	private String total;
	
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	public String getCst() {
		return cst;
	}
	public void setCst(String cst) {
		this.cst = cst;
	}
	public String getCfop() {
		return cfop;
	}
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getVlrUnit() {
		return vlrUnit;
	}
	public void setVlrUnit(String vlrUnit) {
		this.vlrUnit = vlrUnit;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
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
