package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lifetree.lifetreeTcc.model.entity.Cliente;
import br.com.lifetree.lifetreeTcc.service.ClienteService;

@Controller
@RequestMapping("lifetree/cliente")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false", allowedHeaders = "*")
public class ClienteController {

	//Criação do objeto de serviço 
	final ClienteService clienteService;


	// INJEÇÃO DE DEPENDENCIA 
	public ClienteController(ClienteService _clienteService) {
		this.clienteService = _clienteService;
	}

	private String serverMessage = null;

	@GetMapping("/login")
	public String getLogin(ModelMap model) {

		model.addAttribute("cliente", new Cliente());
		model.addAttribute("serverMessage", serverMessage);
		return "login";

	}

	//Rota POST para acessar o site
	@PostMapping("/acessar")
	public String acessar(
			@RequestParam("email") String email,
			@RequestParam("senha") String senha, ModelMap model) {

		int acessar = clienteService.acessar(email, senha);


		if(acessar == 1) {
			return "redirect:lifetree/cliente/home";
		}
		serverMessage = "Dados icorretos";
		model.addAttribute("serverMessage", serverMessage);

		return "redirect:lifetree/cliente/login";
	}
	


	//ROTA POST para salvar
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

	@GetMapping ("/home")
	public String getHome(){
		return "home";
	} 
	
	@GetMapping ("/criarconta")
	public String getCriarConta(){
		return "CriarConta";
	} 
	
	

}
