package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
	
	final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository _funcionarioRepository) {
		this.funcionarioRepository = _funcionarioRepository;
	}
	
	@Transactional
	public int acessar(String email, String senha) {
		Funcionario funcionario = funcionarioRepository.findByEmail(email);
		
		if(funcionario != null && funcionario.getStatus().equals("Ativo")) {
			
			if(funcionario.getSenha().equals(senha)) {
				if(funcionario.getAcesso().equals("ADMIN")) {
					return 1;
				}else if(funcionario.getAcesso().equals("func")) {
					return 2;
				}
			}else {return 0;}
		}
		return 0;
	}
	
	public List<Funcionario> findAll(){
		List<Funcionario> lista = funcionarioRepository.findAll();
		return lista;
	}
	
}
