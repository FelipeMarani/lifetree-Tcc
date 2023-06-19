package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	//objeto repository
	final EnderecoRepository enderecoRepository;
	
	//injeção de dependência
	public EnderecoService(EnderecoRepository _enderecoService) {
		this.enderecoRepository = _enderecoService;
	}

}
