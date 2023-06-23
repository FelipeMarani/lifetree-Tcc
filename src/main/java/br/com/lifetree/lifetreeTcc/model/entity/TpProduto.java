package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TpProduto")
public class TpProduto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String TpProduto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTpProduto() {
		return TpProduto;
	}

	public void setTpProduto(String tpProduto) {
		TpProduto = tpProduto;
	}
	

}
