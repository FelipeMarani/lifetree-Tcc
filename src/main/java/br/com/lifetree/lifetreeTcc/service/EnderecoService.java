package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Endereco;
import br.com.lifetree.lifetreeTcc.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	
	//objeto repository
	final EnderecoRepository enderecoRepository;
	
	//injeção de dependência
	public EnderecoService(EnderecoRepository _enderecoService) {
		this.enderecoRepository = _enderecoService;
	}

	//METODO INSERT INTO ENDEREÇO 
		@Transactional
		public Endereco save(Endereco _endereco) {
			return enderecoRepository.save(_endereco);
		}
		
		
		//METODO SELECT * FROM ENDEREÇO
				public List<Endereco> findAll(){
					List<Endereco> lista = enderecoRepository.findAll();
					return lista;
				}
	
	
}
