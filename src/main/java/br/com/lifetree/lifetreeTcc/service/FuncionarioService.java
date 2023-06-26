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
	public Funcionario save(Funcionario _funcionario) {
		return funcionarioRepository.save(_funcionario);
	}
	
	public List<Funcionario> findAll(){
		List<Funcionario> lista = funcionarioRepository.findAll();
		return lista;
	}
	
}
