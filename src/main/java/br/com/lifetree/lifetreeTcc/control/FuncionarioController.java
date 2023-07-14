package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.service.FuncionarioService;

@RestController
@RequestMapping("/lifetree/funcionario")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioController {

	// CRIAÇÃO DO OBJETO DE SERVIÇO 
	final FuncionarioService funcionarioService;


	//INJEÇÃO DE DEPENDENCIA 

	public FuncionarioController(FuncionarioService _funcionarioService) {
		this.funcionarioService = _funcionarioService;

	}

	private String serverMessage = null;

	@GetMapping("/Funclogin")
	public String getFuncLogin() {
		return "Funclogin";
	}

	@PostMapping("/logar")
	public String acessar(
			@RequestParam("email") String email,
			@RequestParam("senha") String senha, ModelMap model) {

		int acessar = funcionarioService.logar(email,senha);

		if(acessar == 1 ) {
			return "redirect:/funcionario/editarfuncionario";
		} else if
		(acessar == 2){
			return "redirect:/funcionario/estoque";
		}
		serverMessage = "Dados Incorretos!";
		model.addAttribute("serverMessage", serverMessage);

		return "redirect:/lifetree/funcionario/login";
	}

	//ROTA GET
	@GetMapping ("/all")
	public ResponseEntity<List<Funcionario>> getAllFuncionario(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(funcionarioService.findAll());
	}

	@GetMapping ("/estoque")
	public String getEstoque(){
		return "estoque";
	} 


}
