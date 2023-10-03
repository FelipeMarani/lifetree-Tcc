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
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.service.FuncionarioService;
import br.com.lifetree.lifetreeTcc.service.ProdutoService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/lifetree/funcionario")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioApiController {

	FuncionarioService funcionarioService;
	ProdutoService produtoService;

	private String serverMessage = null;

	public FuncionarioApiController(FuncionarioService _funcionarioService, ProdutoService produtoService) {

		this.funcionarioService = _funcionarioService;
		this.produtoService = produtoService;

	}
	@GetMapping("/ListaFunc")
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
	
	@PostMapping("/logarApi")
	public ResponseEntity<Funcionario> Acessar(ModelMap map, @RequestBody Funcionario _funcionario, HttpSession session) {
		try {
			Funcionario funcionario = funcionarioService.acessar(_funcionario.getEmail(), _funcionario.getSenha());

			if (funcionario != null) {
				return new ResponseEntity<>(funcionario, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PostMapping("/funcionarioApi")
//	public ResponseEntity<Funcionario> getOneFuncionario(
//			@RequestBody Funcionario funcionario) {
//
//		try {
//			int resposta = funcionarioService.logarApp(funcionario.getEmail(), funcionario.getSenha());
//
//			if (resposta == 1) {
//
//				Funcionario f2 = funcionarioService.findByEmail(funcionario.getEmail());
//
//				return new ResponseEntity<Funcionario>(f2, HttpStatus.OK);
//
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	@GetMapping("/produtosApi")
	public ResponseEntity<List<Produto>> getAllProdutos(@RequestParam(required = false) String title2) {
		try {
			List<Produto> produtosApi = new ArrayList<Produto>();

			if (title2 == null)
				produtoService.ListarTodosProd().forEach(produtosApi::add);

			if (produtosApi.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(produtosApi, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
