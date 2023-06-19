package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.Cliente;
import br.com.lifetree.lifetreeTcc.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	//objeto repository
	final ClienteRepository clienteRepository;
	
	//injeção de dependência
	public ClienteService(ClienteRepository _clienteService) {
		this.clienteRepository = _clienteService;
	}
	
	//METODO INSERT INTO PRODUTO 
	@Transactional
	public Cliente save(Cliente _cliente) {
		return clienteRepository.save(_cliente);
	}

	//METODO SELECT * FROM PRODUTO
	public List<Cliente> findAll(){
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}
	
}
