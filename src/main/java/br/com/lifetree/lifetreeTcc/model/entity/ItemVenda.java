package br.com.lifetree.lifetreeTcc.model.entity;

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
	
	private int Quant;
 	private String StatusItem;
 	
 	@ManyToOne
 	@JoinColumn(name = "Produto_id")
	private Produto produto;
 	
 	@ManyToOne
 	@JoinColumn(name = "Venda_id")
	private Venda venda;
 	
	public void setId(long id) {
		this.id = id;
	}
	public int getQuant() {
		return Quant;
	}
	public void setQuant(int quant) {
		Quant = quant;
	}
	public String getStatusItem() {
		return StatusItem;
	}
	public void setStatusItem(String statusItem) {
		StatusItem = statusItem;
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
