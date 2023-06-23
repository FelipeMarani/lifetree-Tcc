package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="Cupom")
public class Cupom {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@JoinColumn(name="NOME")
	private String nome;
	
	@JoinColumn(name="STATUSCP")
	private String statuscp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatuscp() {
		return statuscp;
	}

	public void setStatuscp(String statuscp) {
		this.statuscp = statuscp;
	}
	
	
}
