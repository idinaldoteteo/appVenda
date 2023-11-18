package br.edu.infinet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tblivro")
public class Livro extends Produto {

	@Size(min = 5, max = 50)
	private String nome;
	@Size(min = 5, max = 50)
	private String editora;
	private float peso;
	
	@Override
	public String toString() {		
		return String.format("[LIVRO] (nome)%s - (editora)%s - (peso)%.2f - %s", nome, editora, peso, super.toString());
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
