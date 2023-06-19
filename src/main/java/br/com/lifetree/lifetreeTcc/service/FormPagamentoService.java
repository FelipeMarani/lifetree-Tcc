package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.repository.FormPagamentoRepository;

@Service
public class FormPagamentoService {

	//objeto repository
	final FormPagamentoRepository formPagamentoRepository;
	
	//injeção de dependências
	public  FormPagamentoService(FormPagamentoRepository _formPagamentoService){
		this.formPagamentoRepository = _formPagamentoService;
	}

}
