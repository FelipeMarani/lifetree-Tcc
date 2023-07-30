package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	
	//exemplo feito pelo Cruz
	@Column(name = "Logradouro")
	private String logradouro;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "Numcasa")
	private String numcasa;
	@Column(name = "Bairro")
	private String bairro;
	@Column(name = "Cidade")
	private String cidade;
	@Column(name = "UF")
	private String uf;
	@Column(name = "Complemento")
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private Cliente cliente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumcasa() {
		return numcasa;
	}

	public void setNumcasa(String numcasa) {
		this.numcasa = numcasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
