package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.Venda;
import br.com.lifetree.lifetreeTcc.service.VendaService;


@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class VendaController {
	
	
	//Criação do objeto de serviço 
	final VendaService vendaService;
	
	// INJEÇÃO DE DEPENDENCIA 
	public VendaController(VendaService _vendaService) {
		this.vendaService = _vendaService;
	}
	
	//ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveVenda(Venda venda){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(vendaService.save(venda));
	}
	
//Rota Get 
	@GetMapping("/all")
	public ResponseEntity<List<Venda>> getAllVenda(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(vendaService.findAll());
	}
	
	
	

}
