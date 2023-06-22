package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.Venda;
import br.com.lifetree.lifetreeTcc.repository.VendaRepository;
import jakarta.transaction.Transactional;

@Service
public class VendaService {

	//objeto repository
	final VendaRepository vendaRepository;
	
	//injeção de dependência
	public  VendaService(VendaRepository _vendaService){
		this.vendaRepository = _vendaService;
		
	}
	
	// INSERT INTO VENDA 
	@Transactional 
	public Venda save(Venda _venda) {
		return vendaRepository.save(_venda);
		
	}
	//SELECT * FROM VENDA 
	public List <Venda>  findAll(){
		List <Venda> lista = vendaRepository.findAll();
		return lista;
	}
	
	
}
