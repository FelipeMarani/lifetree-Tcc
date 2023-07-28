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
	private double Preco;
	private int Quantidade;
	private String cod_barra;
	private String Destaque;
	@Column(name = "StatusProd")
	private String Status; 
	private String descricao;
	private byte[] Imagem;
	
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
	public String getDestaque() {
		return Destaque;
	}

	public void setDestaque(String destaque) {
		Destaque = destaque;
	}
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	public byte[] getImagem() {
		return Imagem;
	}

	public void setImagem(byte[] imagem) {
		Imagem = imagem;
	}
	
	
	
	
	
	

}
