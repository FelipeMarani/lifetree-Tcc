package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.repository.VendaRepository;

@Service
public class VendaService {

	//objeto repository
	final VendaRepository vendaRepository;
	
	//injeção de dependência
	public  VendaService(VendaRepository _vendaService){
		this.vendaRepository = _vendaService;
		
	}
	
}
