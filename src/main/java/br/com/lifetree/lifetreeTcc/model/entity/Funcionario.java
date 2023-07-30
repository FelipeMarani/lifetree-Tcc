package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name = "Nome")
	private String nome; 
	@Column(name ="CPF")
	private String cpf;
	@Column(name = "RG")
	private String rg;
	@Column(name = "Sexo")
	private String sexo;
	private String dataNasc;
	@Column(name = "Img")
	private byte[] img;
	private String telefone;
	@Column(name = "Email")
	private String email;
	private String Senha;
	@Column(name = "NivelAcess")
	private String acesso;
	@Column(name = "statusFunc")
	private String status;
	@Column(name = "Logradouro")
	private String logradouro;
	@Column(name = "Numero_resid")
	private String nm_resid;
	@Column(name = "Complemento")
	private String complemento;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "Bairro")
	private String bairro;
	@Column(name = "Cidade")
	private String cidade;
	@Column(name = "UF")
	private String uf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNm_resid() {
		return nm_resid;
	}
	public void setNm_resid(String nm_resid) {
		this.nm_resid = nm_resid;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	
}
