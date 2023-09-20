package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.repository.FuncionarioRepository;
import br.com.lifetree.lifetreeTcc.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

	final FuncionarioRepository funcionarioRepository;
	final ProdutoRepository produtoRepository;

	public FuncionarioService(FuncionarioRepository _funcionarioRepository , ProdutoRepository _produtoRepository) {
		super();
		this.produtoRepository = _produtoRepository;
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
				return 1;
			}
		} else if (funcionario != null && funcionario.getAcesso().equals("FUNC")) {

			if (funcionario.getSenha().equals(senha)) {
				return 2;
			}
		} else {
			return 0;
		}

		return 0;
	}
	
	
	
	@Transactional
	public void atualizarFunc(Funcionario funcionario) {

		funcionarioRepository.save(funcionario);

	}

	// filtro
	public List<Funcionario> TodosFuncionarios() {
		List<Funcionario> lista = funcionarioRepository.findAll();
		return lista;
	}

	// todos
	public List<Funcionario> ListarTodos() {
		return funcionarioRepository.findAll();
	}
	
	
	//
		public Funcionario ListarEmail(String email){
			
			return funcionarioRepository.findByEmail(email);
		}
	
	@Transactional
	public Funcionario saveNewFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void inativarFunc(Funcionario funcionario) {

		Funcionario _funcionario = funcionario;

		_funcionario.setEmail("NULL");
		_funcionario.setSenha("NULL");
		_funcionario.setAcesso("INATIVO");
		funcionarioRepository.save(_funcionario);
	}
	
	public void inativarProdFunc(Produto produto) {

		Produto _produto = produto;

		_produto.setPreco(0.0);
		_produto.setQuantidade(0);
		_produto.setDestaque("NÃO");
		_produto.setStatusProd("INATIVO");
		produtoRepository.save(_produto);
	}
	

//	public void reativar

}
