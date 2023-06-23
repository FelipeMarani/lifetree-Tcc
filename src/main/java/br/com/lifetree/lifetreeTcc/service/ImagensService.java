package br.com.lifetree.lifetreeTcc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.model.entity.Imagens;
import br.com.lifetree.lifetreeTcc.repository.ImagensRepository;
import jakarta.transaction.Transactional;


@Service
public class ImagensService {
	
	//objeto repository
	final ImagensRepository imagensRepository;
	
	//injeção de dependências
	public  ImagensService(ImagensRepository _imagensService){
		this.imagensRepository = _imagensService;
		
	}
	
	//METODO INSERT INTO IMAGENS 
		@Transactional
		public Imagens save(Imagens _imagens) {
			return imagensRepository.save(_imagens);
		}

		//METODO SELECT * FROM IMAGENS
		public List<Imagens> findAll(){
			List<Imagens> lista = imagensRepository.findAll();
			return lista;
		}

}
