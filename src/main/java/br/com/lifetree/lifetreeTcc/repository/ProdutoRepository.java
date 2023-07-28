package br.com.lifetree.lifetreeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
		// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE A TABELA
	
		List<Produto> findByNomeContaining(String nome);
		

}
