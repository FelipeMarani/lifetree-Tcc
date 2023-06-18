package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.ItemVendaRepository;

@Service
public class ItemVendaService {

	//objeto repository
	final ItemVendaRepository itemVendaRepository;
	
	//injeção de dependência
	public  ItemVendaService(ItemVendaRepository _itemVendaService) {
		this.itemVendaRepository = _itemVendaService;
	}
}
