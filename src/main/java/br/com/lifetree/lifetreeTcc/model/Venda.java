package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private double TT_compra;
	private String Dt_Venda;
	private int Pagamento_id;
	private int Cliente_id;
	private int Produto_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTT_compra() {
		return TT_compra;
	}
	public void setTT_compra(double tT_compra) {
		TT_compra = tT_compra;
	}
	public String getDt_Venda() {
		return Dt_Venda;
	}
	public void setDt_Venda(String dt_Venda) {
		Dt_Venda = dt_Venda;
	}
	public int getPagamento_id() {
		return Pagamento_id;
	}
	public void setPagamento_id(int pagamento_id) {
		Pagamento_id = pagamento_id;
	}
	public int getCliente_id() {
		return Cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		Cliente_id = cliente_id;
	}
	public int getProduto_id() {
		return Produto_id;
	}
	public void setProduto_id(int produto_id) {
		Produto_id = produto_id;
	}
	
}
