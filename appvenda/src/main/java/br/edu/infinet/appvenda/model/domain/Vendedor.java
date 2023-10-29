package br.edu.infinet.appvenda.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbvendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private String cpf;
	private String email;
	@OneToMany
	@JoinColumn(name = "id_vendedor")
	private List<Produto> produtoList;
	
	
	@Override
	public String toString() {		
		return String.format("[VENDEDOR] %s - %s - %s", nome, cpf, email);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public List<Produto> getProdutoList() {
		return produtoList;
	}
	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public static Vendedor CriarVendedor(int id) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(id);
		return vendedor;
	}
	
}
