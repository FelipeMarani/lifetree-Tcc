package br.com.lifetree.lifetreeTcc.control;

import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;
import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.service.FuncionarioService;
import br.com.lifetree.lifetreeTcc.service.McProdutoService;
import br.com.lifetree.lifetreeTcc.service.ProdutoService;
import br.com.lifetree.lifetreeTcc.service.TpProdutoService;

@Controller
@RequestMapping("/lifetree/funcionario")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class FuncionarioController {

	// CRIAÇÃO DO OBJETO DE SERVIÇO
	final ProdutoService produtoService;
	final FuncionarioService funcionarioService;
	final TpProdutoService tpProdutoService;
	final McProdutoService mcProdutoService;

	// INJEÇÃO DE DEPENDENCIA

	public FuncionarioController(FuncionarioService _funcionarioService, TpProdutoService tpProdutoService,
			McProdutoService mcProdutoService, ProdutoService produtoService) {
		this.funcionarioService = _funcionarioService;
		this.tpProdutoService = tpProdutoService;
		this.mcProdutoService = mcProdutoService;
		this.produtoService = produtoService;

	}

	private String serverMessage = null;
	private String semImagem = "/img/semImagem.png";
	private String foto = "";

	@GetMapping("/login")
	public String getLogin(ModelMap model) {

		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("serverMessage", serverMessage);
		return "login";

	}

	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getAllProduto() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.ListarTodos());
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

	
	@PostMapping("/save")
	public String saveFuncionario(@ModelAttribute Funcionario funcionario) {

		funcionarioService.saveNewFuncionario(funcionario);

		return "redirect:/lifetree/funcionario/login";
	}

	@PostMapping("/todos-filtro")
	public String mostrarTodosFiltro(ModelMap model, @RequestParam(value = "nomeProd", required = false) String nome) {

		if (nome.trim().equals("")) {
			model.addAttribute("produtos", produtoService.ListarTodos());
		} else {
			model.addAttribute("produtos", produtoService.listarTodosFiltro(nome));
		}
		return "redirect:/lifetree/funcionario/EstoqueADM";
	}

	@GetMapping("/loginfuncionario")
	public String getLoginFuncionario(ModelMap model) {
		model.addAttribute("funcionario", new Funcionario());
		return "loginFuncionario";
	}

	@GetMapping("/criarconta")
	public String getCriarConta(ModelMap map) {
		map.addAttribute("funcionario", new Funcionario());
		return "CriarConta";
	}

	@PostMapping("/atualizar/{id}")
	public String atualizarProduto(@PathVariable("id") int id, ModelMap model) {

		Funcionario funcionario = funcionarioService.findById(id);

		model.addAttribute("Funcionario", funcionario);

		funcionarioService.atualizarFunc(funcionario);
		return "redirect:/lifetree/funcionario/ListaFunc";
	}

	@GetMapping("/ListaFunc")
	public String getLista(ModelMap map) {
		map.addAttribute("funcionario", funcionarioService.ListarTodos());
		return "ListaFunc";
	}

	@PostMapping("/inativar/{id}")
	public String inativarFunc(@PathVariable("id") int id, Funcionario funcionario, ModelMap model) {

		funcionarioService.inativarFunc(funcionario);

		return "redirect:/lifetree/funcionario/ListaFunc";
	}

	@GetMapping("/EditarFuncionario/{id}")
	public String getEditarFuncionario(@PathVariable("id") int id, ModelMap map) {
		Funcionario funcionario = funcionarioService.findById(id);

		map.addAttribute("funcionario", funcionario);

		return "EditarFuncionario";
	}
	
	//ADM////

	@GetMapping("/EstoqueADM")
	public String getEstoque(ModelMap model) {
		model.addAttribute("produtos", produtoService.ListarTodos());
		return "EstoqueADM";
	}
	
	@GetMapping("/AdicionarProdutoADM")
	public String getadicionarProdutosADM(ModelMap model) {
		model.addAttribute("tpProdutos", tpProdutoService.findAll());
		model.addAttribute("mcProdutos", mcProdutoService.findAll());
		model.addAttribute("produto", new Produto());
		return "AdicionarProdutoADM";
	}

	


}
