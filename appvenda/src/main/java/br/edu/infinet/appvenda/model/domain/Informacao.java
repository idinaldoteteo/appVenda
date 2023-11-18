package br.edu.infinet.appvenda.model.domain;

public class Informacao {

	private Integer Id;
	private String campo;
	private String descricao;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id: %d - (campo)%s - (descricao)%s",
				Id,
				campo, 
				descricao
				);
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
