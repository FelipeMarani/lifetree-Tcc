package br.com.lifetree.lifetreeTcc.control;

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
import jakarta.servlet.http.HttpSession;

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
	public String Acessar(ModelMap map, @RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session) {

		Funcionario funclogado = funcionarioService.acessar(email, senha);

		if (funclogado != null) {
			session.setAttribute("funclogado", funclogado);
			if (funclogado.getAcesso().equals("FUNC")) {
				return "redirect:/lifetree/produtos/Estoque";
			} else if (funclogado.getAcesso().equals("ADMIN")) {
				return "redirect:/lifetree/funcionario/ListaFunc";
			}
		}

		return "redirect:/lifetree/funcionario/login";
	}

	@PostMapping("/save")
	public String saveFuncionario(@ModelAttribute Funcionario funcionario) {

		funcionario.setAcesso("FUNC");

		funcionarioService.saveNewFuncionario(funcionario);

		return "redirect:/lifetree/funcionario/login";
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

	@GetMapping("/ListaFunc_")
	public String getLista(ModelMap map) {
		map.addAttribute("funcionario", funcionarioService.ListarTodos());
		return "ListaFunc";
	}

	@GetMapping("/inativar/{id}")
	public String inativarFunc(@PathVariable("id") int id, ModelMap model) {

		Funcionario funcionario = funcionarioService.findById(id);

		funcionarioService.inativarFunc(funcionario);

		return "redirect:/lifetree/funcionario/ListaFunc";
	}

	@GetMapping("/Filtro_Func")
	public String MostrarFiltroFunc(ModelMap map) {

		map.addAttribute("funcionario", funcionarioService.ListarTodos());
		return "FiltroFuc";

	}

	@GetMapping("/ListaFunc")
	public String verFuncionarios(ModelMap model, @RequestParam(value = "funcionario", required = false) String nome) {

		List<Funcionario> funcionarios = null;

		if (nome == null) {
			funcionarios = funcionarioService.TodosFuncionarios();
			model.addAttribute("funcionarios", funcionarios);
		} else {
			funcionarios = funcionarioService.FiltroFunc(nome);
			model.addAttribute("funcionarios", funcionarios);
		}

		serverMessage = null;

		// INDICA A PÁGINA QUE SERÁ CARREGADA NA EXECUÇÃO DO MÉTODO
		return "ListaFunc";
	}

	// ADM////

	@GetMapping("/EditarFuncionario/{id}")
	public String getEditarFuncionario(@PathVariable("id") int id, ModelMap map) {
		Funcionario funcionario = funcionarioService.findById(id);

		map.addAttribute("funcionario", funcionario);

		return "EditarFuncionario";
	}

	@GetMapping("/inativarProdAdm/{id}")
	public String inativarProdFunc(@PathVariable("id") int id, Produto produto, ModelMap model) {

		Produto produtos = produtoService.findById(id);

		funcionarioService.inativarProdFunc(produtos);

		return "redirect:/lifetree/funcionario/EstoqueADM";
	}

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

	@PostMapping("/atualizar")
	public String atualizarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {

		funcionarioService.atualizarFunc(funcionario);
		return "redirect:/lifetree/funcionario/ListaFunc";
	}

}
