package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.Cliente;
import br.com.lifetree.lifetreeTcc.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class ClienteController {
	
	//Criação do objeto de serviço 
			final ClienteService clienteService;
			

			// INJEÇÃO DE DEPENDENCIA 
			public ClienteController(ClienteService _clienteService) {
				this.clienteService = _clienteService;
			}
			

			//ROTA POST
			@PostMapping ("/save")
			public ResponseEntity<Object> saveCliente(Cliente cliente){
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(clienteService.save(cliente));

			}
			//ROTA GET
			@GetMapping ("/all")
			public ResponseEntity<List<Cliente>> getAllCliente(){
				return ResponseEntity.status(HttpStatus.OK)
						.body(clienteService.findAll());
			}

	
}
