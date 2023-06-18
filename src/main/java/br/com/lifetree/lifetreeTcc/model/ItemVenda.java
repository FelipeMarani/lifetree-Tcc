package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ItemVenda")
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private int Quant;
 	private String StatusItem;
	private int Produto_id;
	private int Venda_id;
	private int Cliente_id;
	public long getId() {
		return id;
	}
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
	public int getProduto_id() {
		return Produto_id;
	}
	public void setProduto_id(int produto_id) {
		Produto_id = produto_id;
	}
	public int getVenda_id() {
		return Venda_id;
	}
	public void setVenda_id(int venda_id) {
		Venda_id = venda_id;
	}
	public int getCliente_id() {
		return Cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		Cliente_id = cliente_id;
	}
	
}
