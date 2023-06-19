package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.Endereco;
import br.com.lifetree.lifetreeTcc.service.EnderecoService;

@RestController
@RequestMapping("/endereço")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class EnderecoController {
	
	//Criação do objeto de serviço 
	final EnderecoService enderecoService;
	
	// INJEÇÃO DE DEPENDENCIA 
	
	public EnderecoController(EnderecoService _enderecoService) {
		this.enderecoService = _enderecoService;
	}
	
	//ROTA POST
		@PostMapping
		public ResponseEntity<Object> saveEndereco(Endereco endereco){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(enderecoService.save(endereco));

		}

		//ROTA GET
	
		@GetMapping 
		public ResponseEntity<List<Endereco>> getAllEndereco(){
			return ResponseEntity.status(HttpStatus.OK)
					.body(enderecoService.findAll());
		}
	

}
