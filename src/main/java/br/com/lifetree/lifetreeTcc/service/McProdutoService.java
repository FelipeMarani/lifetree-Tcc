package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.McProduto;
import br.com.lifetree.lifetreeTcc.repository.McProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class McProdutoService {

	// objeto repository
	final McProdutoRepository mcProdutoRepository;

	// injeção de dependência
	public McProdutoService(McProdutoRepository _mcProdutoService) {
		this.mcProdutoRepository = _mcProdutoService;

	}

	// Metodo Insert INTO MarcaDoProduto
	@Transactional
	public McProduto save(McProduto _mcProduto) {
		return mcProdutoRepository.save(_mcProduto);
	}

	// Metodo Select * From MarcaDoProduto
	public List<McProduto> findAll() {
		List<McProduto> lista = mcProdutoRepository.findAll();
		return lista;
	}

}
