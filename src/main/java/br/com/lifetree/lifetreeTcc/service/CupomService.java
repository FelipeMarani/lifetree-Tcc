package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Cupom;
import br.com.lifetree.lifetreeTcc.repository.CupomRepository;
import jakarta.transaction.Transactional;

@Service
public class CupomService {

	//objeto repository
	final CupomRepository cupomRepository;
	
	//injeção de dependência
	public CupomService(CupomRepository _cupomService) {
		this.cupomRepository = _cupomService;
	}
	
	//Metodo INSERT INTO 
	@Transactional
	public Cupom save(Cupom _cupom) {
		return cupomRepository.save(_cupom);
	}
	
	//METODO SELECT * FROM CLIENTE
	public List<Cupom> findall(){
		List<Cupom> lista = cupomRepository.findAll();
		return lista;
	}
	
}
