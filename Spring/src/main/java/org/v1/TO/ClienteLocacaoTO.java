package org.v1.TO;

public class ClienteLocacaoTO {

	private Integer totalLocacao;
	private String nome;
	
	public ClienteLocacaoTO(Integer totalLocacao, String nome) {
		super();
		this.totalLocacao = totalLocacao;
		this.nome = nome;
	}
	public Integer getTotalLocacao() {
		return totalLocacao;
	}
	public void setTotalLocacao(Integer totalLocacao) {
		this.totalLocacao = totalLocacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
