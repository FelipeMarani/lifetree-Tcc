package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Imagens;
import br.com.lifetree.lifetreeTcc.service.ImagensService;

@RestController
@RequestMapping("/imagens")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
public class ImagensController {
	
	final ImagensService imagensService;
	
	// INJEÇÃO DE DEPENDENCIA 
				public ImagensController(ImagensService _imagensService) {
					this.imagensService = _imagensService;
				}
				

				//ROTA POST
				@PostMapping("/save")
				public ResponseEntity<Object> saveImagens(Imagens imagens){
					return ResponseEntity.status(HttpStatus.CREATED)
							.body(imagensService.save(imagens));

				}
				//ROTA GET
				@GetMapping ("/all")
				public ResponseEntity<List<Imagens>> getAllCliente(){
					return ResponseEntity.status(HttpStatus.OK)
							.body(imagensService.findAll());
				}

}
