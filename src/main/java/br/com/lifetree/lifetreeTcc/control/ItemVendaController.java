package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.ItemVenda;
import br.com.lifetree.lifetreeTcc.service.ItemVendaService;

@RestController
@RequestMapping("/itemvendas")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class ItemVendaController {
	
	
	
	//Criação do objeto de serviço 
	final ItemVendaService ItemVendaService;
	
	// INJEÇÃO DE DEPENDENCIA 
	
	public ItemVendaController(ItemVendaService _itemvendaService) {
		this.ItemVendaService = _itemvendaService;
	}
	
	//ROTA POST
		@PostMapping("/save")
		public ResponseEntity<Object> saveItemVenda(ItemVenda itemvenda){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(ItemVendaService.save(itemvenda));

		}

		//ROTA GET
		
		@GetMapping ("/all")
		public ResponseEntity<List<ItemVenda>> getAllItemVenda(){
			return ResponseEntity.status(HttpStatus.OK)
					.body(ItemVendaService.findAll());
		}

}
