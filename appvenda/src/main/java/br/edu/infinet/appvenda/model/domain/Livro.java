package br.edu.infinet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblivro")
public class Livro extends Produto {

	private String nome;
	private String editora;
	private float peso;
	
	@Override
	public String toString() {		
		return String.format("[LIVRO] %s - %s - %.2f - %s", nome, editora, peso, super.toString());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}
