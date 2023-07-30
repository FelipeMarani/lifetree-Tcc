package br.com.lifetree.lifetreeTcc.model.entity;

import jakarta.persistence.Column;
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
	
	@Column(name = "Fm_pagamento")
	private String fm_pagamento;
	@Column(name = "Statuspg")
	private String statuspg;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFm_pagamento() {
		return fm_pagamento;
	}
	public void setFm_pagamento(String fm_pagamento) {
		this.fm_pagamento = fm_pagamento;
	}
	public String getStatuspg() {
		return statuspg;
	}
	public void setStatuspg(String statuspg) {
		this.statuspg = statuspg;
	}
	
	
	
}
