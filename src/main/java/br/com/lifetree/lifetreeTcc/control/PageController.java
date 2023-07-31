package br.com.lifetree.lifetreeTcc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/lifetree")
public class PageController {

		@GetMapping("/login")
		public String getLogin(){
			return "login";
		}

	@GetMapping ("/home")
	public String getHome(){
		return "home";
	} 

	@GetMapping("/criarconta")
	public String getcriarconta() {
		return "CriarConta";
	}

	@GetMapping("/AdicionarProduto")
	public String getadicionarProdutos() {
		return "AdicionarProduto";
	}

}
