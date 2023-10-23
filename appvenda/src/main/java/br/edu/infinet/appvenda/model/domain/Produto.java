package br.edu.infinet.appvenda.model.domain;

import java.util.List;

public class Produto {

	private String descricao;
	private int codigo;
	private float preco;
	private boolean estoque;
	private List<Produto> produtos;
	
	@Override
	public String toString() {		
		return String.format("[PRODUTO] %s - %s - %.2f - %s", descricao, codigo, preco, estoque);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
