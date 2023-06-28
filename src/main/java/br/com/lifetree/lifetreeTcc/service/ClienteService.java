package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Cliente;
import br.com.lifetree.lifetreeTcc.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	// objeto repository
	final ClienteRepository clienteRepository;

	// injeção de dependência
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// METODO INSERT INTO CLIENTE
	@Transactional
	public Cliente save(Cliente _cliente) {
		return clienteRepository.save(_cliente);
	}

	// METODO SELECT * FROM CLIENTE
	public List<Cliente> findAll() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}

	// Verificação de usuário
	@Transactional
	public int acessar(String email, String senha) {
		Cliente cliente = clienteRepository.findByEmail(email);

		if (cliente != null && cliente.getStatus().equals("Ativo")) {

			if (cliente.getSenha().equals(senha)) {

				return 1;

			}
		}
		return 0;
	}

}
