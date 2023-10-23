package br.edu.infinet.appvenda.model.domain;

public class Vestuario extends Produto {

	private String tamanho;
	private String marca;
	private boolean estampada;
	
	@Override
	public String toString() {		
		return String.format("[VESTUARIO] %s - %s - %s -%s", tamanho, marca, estampada, super.toString());
	}
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isEstampada() {
		return estampada;
	}
	public void setEstampada(boolean estampada) {
		this.estampada = estampada;
	}
	
}
