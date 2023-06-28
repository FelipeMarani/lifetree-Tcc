package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String Nome;
	private double Preco;
	private int Quantidade;
	private String cod_barra;
	private double Peso;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "tpProduto_id")
	private TpProduto tpProduto;
	
	@ManyToOne
	@JoinColumn(name = "mcProduto_id")
	private McProduto mcProduto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public String getCod_barra() {
		return cod_barra;
	}

	public void setCod_barra(String cod_barra) {
		this.cod_barra = cod_barra;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TpProduto getTpProduto() {
		return tpProduto;
	}

	public void setTpProduto(TpProduto tpProduto) {
		this.tpProduto = tpProduto;
	}

	public McProduto getMcProduto() {
		return mcProduto;
	}

	public void setMcProduto(McProduto mcProduto) {
		this.mcProduto = mcProduto;
	}
	
	
	
	
	
	

}