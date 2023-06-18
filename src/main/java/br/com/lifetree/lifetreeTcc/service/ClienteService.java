package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.ClienteRepository;

@Service
public class ClienteService {
	
	//objeto repository
	final ClienteRepository clienteRepository;
	
	//injeção de dependência
	public ClienteService(ClienteRepository _clienteService) {
		this.clienteRepository = _clienteService;
	}
	
}
