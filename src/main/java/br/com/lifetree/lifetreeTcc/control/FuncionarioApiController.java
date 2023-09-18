package br.com.lifetree.lifetreeTcc.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.service.FuncionarioService;

@RestController
@RequestMapping("/api/lifetree/funcionario")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioApiController {

	FuncionarioService funcionarioService;

	public FuncionarioApiController(FuncionarioService _funcionarioService) {
		this.funcionarioService = _funcionarioService;

	}

	private String serverMessage = null;

	@GetMapping("/login")
	@ResponseBody
	public String getLogin(ModelMap model) {

		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("serverMessage", serverMessage);
		return "login";

	}

	@PostMapping("/logar")
	public String Acessar(@RequestParam("email") String email, @RequestParam("senha") String senha, ModelMap model) {

		int acessar = funcionarioService.acessar(email, senha);

		if (acessar == 2) {

			return "redirect:/lifetree/produtos/Estoque";
		} else if (acessar == 1) {

			return "redirect:/lifetree/funcionario/ListaFunc";
		}

		return "redirect:/lifetree/funcionario/login";
	}
	
	 @GetMapping("/tutorials")
	  public ResponseEntity<List<Funcionario>> getAllFuncionarios(@RequestParam(required = false) String title) {
	    try {
	      List<Funcionario> tutorials = new ArrayList<Funcionario>();

	      if (title == null)
	    	  funcionarioService.TodosFuncionarios().forEach(tutorials::add);
	   
	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody Funcionario loginDto){
    	
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
}
