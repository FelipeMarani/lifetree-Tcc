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
@Table(name="Produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Nome")
	private String nome;
	@Column(name = "Preco")
	private double preco;
	@Column(name = "Quantidade")
	private int quantidade;
	@Column(name = "Destaque")
	private String destaque;
	@Column(name = "StatusProd")
	private String statusProd;
	@Column(name = "Complemento")
	private String descricao;
	@JoinColumn(name ="imagem_id")
	private byte[] imagem;
	
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

	public String getDestaque() {
		return destaque;
	}

	public void setDestaque(String destaque) {
		this.destaque = destaque;
	}

	

	public String getStatusProd() {
		return statusProd;
	}

	public void setStatusProd(String statusProd) {
		this.statusProd = statusProd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
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
