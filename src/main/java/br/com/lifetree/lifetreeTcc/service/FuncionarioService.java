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
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
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

}

