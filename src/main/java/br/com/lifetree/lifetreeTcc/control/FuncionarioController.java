package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioController {

		// CRIAÇÃO DO OBJETO DE SERVIÇO 
			final FuncionarioService funcionarioService;
			
			
		//INJEÇÃO DE DEPENDENCIA 
			
			public FuncionarioController(FuncionarioService _funcionarioService) {
				this.funcionarioService = _funcionarioService;
			
			}
		// ROTA POST 
			@PostMapping("/save")
			public ResponseEntity<Object> saveFuncionario(Funcionario funcionario){
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(funcionarioService.save(funcionario));
			}
			
			//ROTA GET
			@GetMapping ("/all")
			public ResponseEntity<List<Funcionario>> getAllFuncionario(){
				return ResponseEntity.status(HttpStatus.OK)
						.body(funcionarioService.findAll());
			}

	
}
