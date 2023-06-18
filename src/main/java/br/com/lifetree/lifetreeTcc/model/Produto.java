package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private double preco;
	private int quantidade;
	private String cod_barra;
	private double peso;
	private int tpProduto_id;
	private int mcProduto_id;
	private String descricao;
	
	
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getCod_barra() {
		return cod_barra;
	}
	public void setCod_barra(String cod_barra) {
		this.cod_barra = cod_barra;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getTpProduto_id() {
		return tpProduto_id;
	}
	public void setTpProduto_id(int tpProduto_id) {
		this.tpProduto_id = tpProduto_id;
	}
	public int getMcProduto_id() {
		return mcProduto_id;
	}
	public void setMcProduto_id(int mcProduto_id) {
		this.mcProduto_id = mcProduto_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
