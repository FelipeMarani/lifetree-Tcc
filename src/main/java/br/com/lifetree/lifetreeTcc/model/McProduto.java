package br.com.lifetree.lifetreeTcc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mcProduto")
public class McProduto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String Marca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}
	
	
}
