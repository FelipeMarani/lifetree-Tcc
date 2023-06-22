package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.FormPagamento;
import br.com.lifetree.lifetreeTcc.repository.FormPagamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class FormPagamentoService {

	//objeto repository
	final FormPagamentoRepository formPagamentoRepository;
	
	//injeção de dependências
	public  FormPagamentoService(FormPagamentoRepository _formPagamentoService){
		this.formPagamentoRepository = _formPagamentoService;
	}

	//METODO INSERT INTO FORMA DE PAGAMENTO 
	@Transactional
	public FormPagamento save(FormPagamento _formPagamento) {
		return formPagamentoRepository.save(_formPagamento);
	}
	//METODO SELECT * FROM FORMA DE PAGAMENTO
	public List<FormPagamento> findAll() {
		List<FormPagamento> lista= formPagamentoRepository.findAll();
				return lista;
	}
	

}
