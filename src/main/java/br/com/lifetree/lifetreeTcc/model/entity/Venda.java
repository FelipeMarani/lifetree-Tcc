package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private double TT_compra;
	private String Dt_Venda;
	
	@ManyToOne
	@JoinColumn(name = "Pagamento_id")
	private FormPagamento pagamento;
	
	@OneToMany
	@JoinColumn(name = "Cliente_id")
	private Cliente cliente;
	
	@OneToMany
	@JoinColumn(name = "Produto_id")
	private Produto produto;
	
	
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

	public FormPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(FormPagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
