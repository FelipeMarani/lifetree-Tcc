package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.repository.McProdutoRepository;
import br.com.lifetree.lifetreeTcc.repository.ProdutoRepository;
import br.com.lifetree.lifetreeTcc.repository.TpProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	//objeto repository
	private  ProdutoRepository produtoRepository; 
	private TpProdutoRepository tpprodutoRepository;
	private McProdutoRepository mcprodutoRepository;
 	
	//Injeção de dependência
	public ProdutoService(ProdutoRepository produtoService , TpProdutoRepository TpProdutoRepository , McProdutoRepository McProdutoRepository) {
		super();
		this.produtoRepository = produtoRepository;
		this.tpprodutoRepository = tpprodutoRepository;
		this.mcprodutoRepository = mcprodutoRepository;
	}
	public Produto findById(long id) {
		return produtoRepository.findById(id).get();
		//return usuarioRepository.findById(id).orElse(null);
		//return usuarioRepository.findById(id)
						//.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
	}
	public List<Produto>ListarTodos(){
		return produtoRepository.ListarTodosProd();
	}
	
	public List<Produto> listarTodosFiltro(String nome){
		return produtoRepository.listarProdutosFiltro(nome);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//METODO INSERT INTO PRODUTO 
			@Transactional
			public Produto save(Produto _produto) {
				return produtoRepository.save(_produto);
			}
			//METODO SELECT * FROM PRODUTO
			public List<Produto> findAll(){
				List<Produto> lista = produtoRepository.findAll();
				return lista;
			}
			
	
}
