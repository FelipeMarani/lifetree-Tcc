package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.McProduto;
import br.com.lifetree.lifetreeTcc.service.McProdutoService;

@RestController
@RequestMapping("/marcaprodutos")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class McProdutoController {

	// Criação do objeto de serviço
	final McProdutoService mcProdutoService;

	// INJEÇÃO DE DEPENDENCIA
	public McProdutoController(McProdutoService _McProdutoService) {
		this.mcProdutoService = _McProdutoService;
	}

	// ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveMcProduto(McProduto mcProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(mcProdutoService.save(mcProduto));
	}

	// ROTA GET
	@GetMapping("/all")
	public ResponseEntity<List<McProduto>> getAllMcProduto() {
		return ResponseEntity.status(HttpStatus.OK).body(mcProdutoService.findAll());
	}

}
