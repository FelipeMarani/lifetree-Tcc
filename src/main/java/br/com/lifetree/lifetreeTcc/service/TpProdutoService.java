package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.TpProdutoRepository;

@Service
public class TpProdutoService {

	//objeto repository
	final TpProdutoRepository tpProdutoRepository;
	
	//injeção de dependência
	public TpProdutoService(TpProdutoRepository _tpProdutoService){
		this.tpProdutoRepository = _tpProdutoService;
	}
	
}
