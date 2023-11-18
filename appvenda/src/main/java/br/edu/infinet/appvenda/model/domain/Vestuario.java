package br.edu.infinet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbvestuario")
public class Vestuario extends Produto {

	@NotBlank
	private String tamanho;
	@NotBlank
	private String marca;
	private boolean estampada;
	
	@Override
	public String toString() {		
		return String.format("[VESTUARIO] (tamanho)%s - (marca)%s - (estampada)%s -%s", tamanho, marca, estampada, super.toString());
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
