package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.Produto;
import br.com.lifetree.lifetreeTcc.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class ProdutoController {

	//Criação do objeto de serviço 
			final ProdutoService produtoService;
			
			// INJEÇÃO DE DEPENDENCIA 
			
			public ProdutoController(ProdutoService _produtoService) {
				this.produtoService = _produtoService;
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
							.body(produtoService.findAll());
				}
	
	
}
