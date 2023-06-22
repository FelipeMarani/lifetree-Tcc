package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.TpProduto;
import br.com.lifetree.lifetreeTcc.repository.TpProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class TpProdutoService {

	//objeto repository
	final TpProdutoRepository tpProdutoRepository;
	
	//injeção de dependência
	public TpProdutoService(TpProdutoRepository _tpProdutoService){
		this.tpProdutoRepository = _tpProdutoService;
	}
	
	// Metodo Insert INTO TipoDoProduto
	@Transactional 
	public TpProduto save (TpProduto _TpProduto) {
		return tpProdutoRepository.save(_TpProduto);
	}
	
	// Metodo Select * From TipoDoProduto
		public List<TpProduto> findAll(){
			List<TpProduto> lista = tpProdutoRepository.findAll();
			return lista;
		}
		
		
	
}
