package br.com.lifetree.lifetreeTcc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
	}
	
	public Funcionario findById(long id) {
		return funcionarioRepository.findById(id).get();
	}


	@Transactional
	public int acessar(String email, String senha) {
		Funcionario funcionario = funcionarioRepository.findByEmail(email);

		if (funcionario != null && funcionario.getAcesso().equals("ADMIN")) {

			if (funcionario.getSenha().equals(senha)) {
				return 1;}
		}
		else if (funcionario != null && funcionario.getAcesso().equals("FUNC")) {

			if (funcionario.getSenha().equals(senha)) {
				return 2;}
		}
		else {
			return 0;
		}
		
		
		
		return 0;
	}
	
	@Transactional
	public void atualizarFunc(Funcionario funcionario) {
		
		funcionarioRepository.save(funcionario);
		
	
		}
	
	
	//filtro
	public List<Funcionario> TodosFuncionarios(){
		List<Funcionario> lista = funcionarioRepository.findAll();
		return lista;
	}
	
	//todos
	public List<Funcionario>ListarTodos(){
		return funcionarioRepository.findAll();
	}
	
	@Transactional
	public Funcionario saveNewFuncionario(Funcionario funcionario) {
		funcionario.setAcesso("FUNC");
		return funcionarioRepository.save(funcionario);
	}
	
	public void inativarFunc(Funcionario funcionario) {

		Funcionario _funcionario = funcionario;

		_funcionario.setEmail("NULL");
		_funcionario.setSenha("NULL");
		_funcionario.setAcesso("INATIVO");
		funcionarioRepository.save(_funcionario);
	}
	
	

}

