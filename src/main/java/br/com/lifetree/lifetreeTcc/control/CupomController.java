package br.com.lifetree.lifetreeTcc.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lifetree.lifetreeTcc.model.entity.Cupom;
import br.com.lifetree.lifetreeTcc.service.CupomService;

@RestController
@RequestMapping("/cupons")
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials  = "false")
public class CupomController {

	//Criação do objeto de serviço
	final CupomService cupomService;
	
	//Injeção de dependência
	public CupomController(CupomService _cupomService) {
		this.cupomService = _cupomService;
	}
	@PostMapping("/save")
	public ResponseEntity<Object> saveCupom(Cupom cupom) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cupomService.save(cupom));
		
	}
	//Rota Get
	@GetMapping
	public ResponseEntity<List<Cupom>> getallCupom(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(cupomService.findall());
	}

}
