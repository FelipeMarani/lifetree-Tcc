package br.com.lifetree.lifetreeTcc.service;

import org.springframework.stereotype.Service;

import br.com.lifetree.lifetreeTcc.repository.ImagensRepository;

@Service
public class ImagensService {
	
	//objeto repository
	final ImagensRepository imagensRepository;
	
	//injeção de dependências
	public  ImagensService(ImagensRepository _imagensService){
		this.imagensRepository = _imagensService;
		
	}

}
