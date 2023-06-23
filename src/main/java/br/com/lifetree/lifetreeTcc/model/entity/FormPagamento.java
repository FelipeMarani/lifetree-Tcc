package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Form_pagamento")
public class FormPagamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String Fm_pagamento;
	private String Statuspg;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFm_pagamento() {
		return Fm_pagamento;
	}
	public void setFm_pagamento(String fm_pagamento) {
		Fm_pagamento = fm_pagamento;
	}
	public String getStatuspg() {
		return Statuspg;
	}
	public void setStatuspg(String statuspg) {
		Statuspg = statuspg;
	}
	
	
}
