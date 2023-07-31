package br.com.lifetree.lifetreeTcc.control;


import java.io.IOException;
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

import br.com.lifetree.lifetreeTcc.model.entity.Cliente;
import br.com.lifetree.lifetreeTcc.model.entity.Produto;
import br.com.lifetree.lifetreeTcc.service.ProdutoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/lifetree/produtos")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class ProdutoController {

	final ProdutoService produtoService;

	private String image = "";

	// CASO O PRODUTO NÃO TENHA UMA IMAGEM CADASTRADA NO BANCO DE DADOS
	private String semImagem = "/images/semImagem.png";

	public ProdutoController(ProdutoService _produtoService) {
		this.produtoService = _produtoService;
	}
	// CARREGA A IMAGEM DO SERVIDOR NA PÁGINA DE ACORDO COM O "ID" DO PRODUTO
	// NA PÁGINA HTML FICA ASSIM: src="/api/v1/produto/show/image/1"
	// CARREGA A URL DA IMAGEM
	@GetMapping("/show/image/{id}")
	@ResponseBody
	public void mostrarImagem(@PathVariable("id") long id, HttpServletResponse response, Produto produto)
			throws ServletException, IOException {

		produto = produtoService.findById(id);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		if (produto.getImagem() != null) {
			response.getOutputStream().write(produto.getImagem());
		} else {
			response.getOutputStream().write(null);
		}

		response.getOutputStream().close();
	}

	@GetMapping("/home")
	public String home(ModelMap model) {

		//List<Produto> produtos = produtoService.listar3Destaques();

		//PARA EXIBIR UMA QUANTIDADE MAIOR DE PRODUTOS EM DESTAQUE
		List<Produto> produtos = produtoService.ListarTodos();

		model.addAttribute("semImagem", semImagem);
		model.addAttribute("produtos", produtos);

		return "home";
	}

	@PostMapping("/todos-filtro")
	public String mostrarTodosFiltro(ModelMap model, 
			@RequestParam(value = "nomeProd", required = false) String nomeProd) {

		if (nomeProd.trim().equals("")) {
			model.addAttribute("produtos", produtoService.ListarTodos());
		} else {
			model.addAttribute("produtos", produtoService.listarTodosFiltro(nomeProd));
		}
		return "todos-produtos-filtro";
	}
	
	
	//ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveProduto(Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoService.save(produto));

	}

	//ROTA GET
	@GetMapping ("/all")
	public ResponseEntity<List<Produto>> getAllProduto(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtoService.ListarTodos());
	}
	
	@GetMapping("/AdicionarProduto")
	public String getadicionarProdutos(ModelMap model) {
		model.addAttribute("produto", new Produto());
		return "AdicionarProduto";
	}
	


}
