package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Cliente;
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
	
	//METODO INSERT INTO CLIENTE 
	@Transactional
	public Cliente save(Cliente _cliente) {
		return clienteRepository.save(_cliente);
	}

	//METODO SELECT * FROM CLIENTE
	public List<Cliente> findAll(){
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}
	
	//Verificação de usuário
	@Transactional
	public int entrar(String email, String senha) {
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente != null && cliente.getStatus().equals("Ativo")) {
			
			if(cliente.getSenha().equals(senha)) {
				
				if(cliente.getNivelAcesso().equals("ADMIN")) {
					return 1;
				}else if(cliente.getNivelAcesso().equals("User")){
					return 2;}
				} 
			else {
				return 0;
			}
		}
		return 0;		
	}
	
}
		
	
