package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	//objeto repository
	final ProdutoRepository produtoRepository;
	
	//Injeção de dependência
	public ProdutoService(ProdutoRepository _produtoService) {
		this.produtoRepository = _produtoService;
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
