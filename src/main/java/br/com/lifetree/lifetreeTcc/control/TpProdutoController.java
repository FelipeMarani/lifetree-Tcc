package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.TpProduto;
import br.com.lifetree.lifetreeTcc.service.TpProdutoService;

@RestController
@RequestMapping("/tipodeprodutos")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
public class TpProdutoController {

	// Criação do objeto de serviço
	final TpProdutoService tpProdutoService;

	// INJEÇÃO DE DEPENDENCIA

	public TpProdutoController(TpProdutoService _tpProdutoService) {
		this.tpProdutoService = _tpProdutoService;
	}

	// ROTA POST
	@PostMapping("/save")
	public ResponseEntity<Object> saveTpProduto(TpProduto tpProduto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tpProdutoService.save(tpProduto));

	}

	@GetMapping("/all")
	public ResponseEntity<List<TpProduto>> getAllTpProduto() {
		return ResponseEntity.status(HttpStatus.OK).body(tpProdutoService.findAll());
	}

}
