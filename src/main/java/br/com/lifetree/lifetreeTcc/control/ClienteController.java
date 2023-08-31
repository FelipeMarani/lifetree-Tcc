//package br.com.lifetree.lifetreeTcc.control;
//
//
//
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import br.com.lifetree.lifetreeTcc.model.entity.Cliente;
//import br.com.lifetree.lifetreeTcc.service.ClienteService;
//import br.com.lifetree.lifetreeTcc.service.FuncionarioService;
//
//@Controller
//@RequestMapping("/lifetree/cliente")
//@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false", allowedHeaders = "*")
//public class ClienteController {
//
//	//Criação do objeto de serviço 
//	final ClienteService clienteService;
//	
//	final FuncionarioService funcionarioService;
//
//	// INJEÇÃO DE DEPENDENCIA 
//	public ClienteController(ClienteService clienteService, FuncionarioService funcionarioService) {
//		super();
//		this.clienteService = clienteService;
//		this.funcionarioService = funcionarioService;
//	}
//	
//	private String serverMessage = null;
//
//	
//
//	@GetMapping("/login")
//	public String getLogin(ModelMap model) {
//
//		model.addAttribute("cliente", new Cliente());
//		model.addAttribute("serverMessage", serverMessage);
//		return "login";
//
//	}
//// AQUI 
//	
//	//Rota POST para acessar o site
//	@PostMapping("/acessar")
//	public String acessar(
//			@RequestParam("email") String email,
//			@RequestParam("senha") String senha, ModelMap model) {
//
//		int acessar = clienteService.acessar(email, senha);
//
//		if(acessar == 1) {
//			return "redirect:/lifetree/cliente/home";
//		}
//		serverMessage = "Dados icorretos";
//		model.addAttribute("serverMessage", serverMessage);
//
//		return "redirect:/lifetree/cliente/login";
//	}
//
//
//
//	//ROTA POST para salvar
//	@PostMapping ("/save")
//	public String saveCliente(@ModelAttribute Cliente cliente) {
//
//		clienteService.saveNewCliente(cliente);
//
//		return "redirect:/lifetree/cliente/login";
//	}
//
//
//	@GetMapping ("/home")
//	public String getHome(){
//		return "home";
//	} 
//
//	@GetMapping ("/criarconta")
//	public String getCriarConta(ModelMap map){
//
//		map.addAttribute("cliente", new Cliente());
//		return "CriarConta";
//	} 
//
//	@GetMapping("/recuperaçãosenha")
//	public String getRecuperaçãoSenha() {
//		return "RecuperaçãoSenha";
//	}
//
//
//
//}