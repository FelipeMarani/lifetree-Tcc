package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.ItemVenda;
import br.com.lifetree.lifetreeTcc.repository.ItemVendaRepository;
import jakarta.transaction.Transactional;

@Service
public class ItemVendaService {

	//objeto repository
	final ItemVendaRepository itemVendaRepository;
	
	//injeção de dependência
	public  ItemVendaService(ItemVendaRepository _itemVendaService) {
		this.itemVendaRepository = _itemVendaService;
	}
	
	//METODO INSERT INTO PRODUTO 
	@Transactional
	public ItemVenda save(ItemVenda _itemvenda) {
		return itemVendaRepository.save(_itemvenda);
	}
	//METODO SELECT * FROM ItemVenda
	public List<ItemVenda> findAll(){
		List<ItemVenda> lista = itemVendaRepository.findAll();
		return lista;
	}

}
