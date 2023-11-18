package br.edu.infinet.appvenda.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbvendedor" , 
	uniqueConstraints = { 
			@UniqueConstraint(columnNames = {"cpf"}),
			@UniqueConstraint(columnNames = {"email"})
	})
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Size(min = 2, max = 50)
	private String nome;
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	private String cpf;
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String email;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "id_vendedor")
	private List<Produto> produtoList;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@Override
	public String toString() {		
		return String.format("[VENDEDOR] id (%d) - (nome) %s - (cpf)%s - (email)%s - (endereco)%s", 
				Id,
				nome, 
				cpf, 
				email,
				endereco
				);
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
