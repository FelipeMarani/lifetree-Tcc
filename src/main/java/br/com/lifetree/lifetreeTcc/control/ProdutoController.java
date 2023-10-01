package br.com.lifetree.lifetreeTcc.control;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.service.McProdutoService;
import br.com.lifetree.lifetreeTcc.service.ProdutoService;
import br.com.lifetree.lifetreeTcc.service.TpProdutoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/lifetree/produtos")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class ProdutoController {

	final ProdutoService produtoService;
	final TpProdutoService tpProdutoService;
	final McProdutoService mcProdutoService;

	// CASO O PRODUTO NÃO TENHA UMA IMAGEM CADASTRADA NO BANCO DE DADOS
	private String semImagem = "/img/semImagem.png";
	private String foto = "";

	public ProdutoController(ProdutoService produtoService, TpProdutoService tpProdutoService,
			McProdutoService mcProdutoService) {
		super();
		this.produtoService = produtoService;
		this.tpProdutoService = tpProdutoService;
		this.mcProdutoService = mcProdutoService;

	}

	// CARREGA A IMAGEM DO SERVIDOR NA PÁGINA DE ACORDO COM O "ID" DO PRODUTO
	// NA PÁGINA HTML FICA ASSIM: src="/api/v1/produto/show/image/1"
	// CARREGA A URL DA IMAGEM
	@GetMapping("/show/image/{id}")
	@ResponseBody
	public void mostrarImagem(@PathVariable("id") long id, HttpServletResponse response, Produto produto)
			throws ServletException, IOException {

		produto = produtoService.findById(id);

		response.setContentType("+image/jpeg, image/jpg, image/png, image/gif");
		if (produto.getImagem() != null) {
			response.getOutputStream().write(produto.getImagem());
		} else {
			response.getOutputStream().write(null);
		}

		response.getOutputStream().close();
	}

	@GetMapping("/home")
	public String home(ModelMap model) {

//		List<Produto> produtos = produtoService.listar3Destaques();

		// PARA EXIBIR UMA QUANTIDADE MAIOR DE PRODUTOS EM DESTAQUE
		List<Produto> produtos = produtoService.ListarTodos();

		model.addAttribute("semImagem", semImagem);
		model.addAttribute("produtos", produtos);

		return "home";
	}

	// ROTA POST
	@PostMapping("/save")
	public String gravarProdutoFunc(@RequestParam(value = "file", required = false) MultipartFile file, Produto produto,
			ModelMap model) {
		produtoService.gravarNovoProd(file, produto);
		return "redirect:/lifetree/produtos/Estoque";
	}

	@PostMapping("/saveADM")
	public String gravarProdutoAdm(@RequestParam(value = "file", required = false) MultipartFile file, Produto produto,
			ModelMap model) {
		produtoService.gravarNovoProd(file, produto);
		return "redirect:/lifetree/funcionario/EstoqueADM";
	}

	// arrumar aqui pra atualizar
	@PostMapping("/atualizar/{id}")
	public String atualizarProduto(@RequestParam(value = "file", required = false) MultipartFile file,
			@PathVariable("id") int id, Produto produto, ModelMap model) {

		byte[] _foto = Base64.getDecoder().decode(foto);

		produtoService.atualizarProd(file, produto, _foto);

		foto = "";

		return "redirect:/lifetree/produtos/Estoque";
	}

	// ROTA GET
	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getAllProduto() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.ListarTodos());
	}

	@GetMapping("/AdicionarProduto")
	public String getadicionarProdutos(ModelMap model) {
		model.addAttribute("tpProdutos", tpProdutoService.findAll());
		model.addAttribute("mcProdutos", mcProdutoService.findAll());
		model.addAttribute("produto", new Produto());
		return "AdicionarProduto";
	}

	@GetMapping("/Editarproduto")
	public String getEditarProduto(ModelMap model) {
		model.addAttribute("produtos", produtoService.ListarTodos());
		return "Editarproduto";
	}

	@GetMapping("/Editarproduto/{id}")
	public String editarProduto(@PathVariable("id") int id, ModelMap model) {

		Produto produto = produtoService.findById(id);

		if (produto.getImagem() != null) {
			if (produto.getImagem().length > 0) {
				foto = Base64.getEncoder().encodeToString(produto.getImagem());
			}
		}

		model.addAttribute("tpProdutos", tpProdutoService.findAll());
		model.addAttribute("mcProdutos", mcProdutoService.findAll());
		model.addAttribute("semImagem", semImagem);
		model.addAttribute("produto", produto);

		return "Editarproduto";
	}

	@GetMapping("/inativar/{id}")
	public String inativarProd(@PathVariable("id") int id, ModelMap model) {

		Produto produto = produtoService.findById(id);

		produtoService.inativarProd(produto);

		return "redirect:/lifetree/produtos/Estoque";
	}

	@GetMapping("/reativar/{id}")
	public String reativarProd(@PathVariable("id") int id, ModelMap model) {

		Produto produto = produtoService.findById(id);

		produtoService.reativarProd(produto);

		return "redirect:/lifetree/produtos/Estoque";
	}

	// ADM//

	@GetMapping("/EditarProdutoADM/{id}")
	public String getEditarProdutoADM(@PathVariable("id") int id, ModelMap map) {

		Produto produto = produtoService.findById(id);
		map.addAttribute("tpProdutos", tpProdutoService.findAll());
		map.addAttribute("mcProdutos", mcProdutoService.findAll());
		map.addAttribute("produto", produto);
		return "EditarProdutoADM";
	}

	@PostMapping("/atualizarProdADM/{id}")
	public String atualizarProdutoADm(@RequestParam(value = "file", required = false) MultipartFile file,
			@PathVariable("id") int id, Produto produto, ModelMap model) {

		byte[] _foto = Base64.getDecoder().decode(foto);

		produtoService.atualizarProd(file, produto, _foto);

		foto = "";

		return "redirect:/lifetree/funcionario/EstoqueADM";
	}

	@GetMapping("/Estoque")
	public String getEstoque(ModelMap model) {
		model.addAttribute("produto", produtoService.ListarTodos());
		return "Estoque";
	}

	@GetMapping("/FiltroProdAdm")
	public String verProdutosAdm(ModelMap model, @RequestParam(value = "produto", required = false) String nome) {

		List<Produto> produtos = null;

		if (nome == null) {
			produtos = produtoService.ListarTodos();
			model.addAttribute("produtos", produtos);
		} else {
			produtos = produtoService.listarTodosFiltro(nome);
			model.addAttribute("produtos", produtos);
		}

		return "EstoqueADM";
	}

	@GetMapping("/FiltroProdFunc")
	public String verProdutosFunc(ModelMap model, @RequestParam(value = "produto", required = false) String nome) {

		List<Produto> produtos = null;

		if (nome == null) {
			produtos = produtoService.ListarTodos();
			model.addAttribute("produtos", produtos);
		} else {
			produtos = produtoService.listarTodosFiltro(nome);
			model.addAttribute("produtos", produtos);
		}

		return "Estoque";
	}

}
