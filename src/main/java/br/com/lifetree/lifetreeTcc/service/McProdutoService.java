package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.McProdutoRepository;

@Service
public class McProdutoService {
	
	//objeto repository
	final McProdutoRepository mcProdutoRepository;
	
	//injeção de dependência
	public McProdutoService(McProdutoRepository _mcProdutoService) {
		this.mcProdutoRepository = _mcProdutoService;
		
	}

}
