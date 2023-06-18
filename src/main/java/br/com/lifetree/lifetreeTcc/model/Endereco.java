package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String Logradouro;
	private String CEP;
	private String Numcasa;
	private String Bairro;
	private String Cidade;
	private String UF;
	private String Complemento;
	private int Cliente_id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNumcasa() {
		return Numcasa;
	}
	public void setNumcasa(String numcasa) {
		Numcasa = numcasa;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public int getCliente_id() {
		return Cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		Cliente_id = cliente_id;
	}
	
	
}
