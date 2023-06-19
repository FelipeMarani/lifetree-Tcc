package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	//objeto repository
	final ProdutoRepository produtoRepository;
	
	//Injeção de dependência
	public ProdutoService(ProdutoRepository _produtoService) {
		this.produtoRepository = _produtoService;
	}
	
}
