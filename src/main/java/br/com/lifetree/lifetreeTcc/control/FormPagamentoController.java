package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.FormPagamento;
import br.com.lifetree.lifetreeTcc.service.FormPagamentoService;

@RestController
@RequestMapping("/formapagamentos")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class FormPagamentoController {

	//Criação do objeto de serviço 
	final FormPagamentoService formpagamentoService; 
	
	// INJEÇÃO DE DEPENDENCIA 
	public FormPagamentoController(FormPagamentoService _formpagamentoService) {
		this.formpagamentoService = _formpagamentoService;
	}
	
	
	//ROTA POST 
	@PostMapping ("/save")
	public ResponseEntity<Object> saveFormPagamento(FormPagamento formpagamento){
		return ResponseEntity.status(HttpStatus.CREATED)
						.body(formpagamentoService.save(formpagamento));
		
	}
	
	//ROTA GET 
	@GetMapping("/all")
	public ResponseEntity <List<FormPagamento>> getAllFormPagamento(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(formpagamentoService.findAll());
		
	}
	
	
	
			
	
}
