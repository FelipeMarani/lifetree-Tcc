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
@Table(name="ItemVenda")
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Quant")
	private int quant;
	@Column(name = "StatusItem")
 	private String statusItem;
 	
 	@ManyToOne
 	@JoinColumn(name = "Produto_id")
	private Produto produto;
 	
 	@ManyToOne
 	@JoinColumn(name = "Venda_id")
	private Venda venda;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
 	
	
}
