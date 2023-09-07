package br.com.lifetree.lifetreeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
		// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE A TABELA
	
		List<Produto> findByNomeContaining(String nome);
		
		List<Produto> findByStatusProd(String status);
		
		// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE A TABELA
		@Query("SELECT p FROM Produto p WHERE p.statusProd = 'ATIVO'")
		List<Produto> listarProdutosAtivos();
		
		@Query("SELECT p FROM Produto p WHERE p.nome like %?1%")
		List<Produto> listarProdutosFiltro(@Param("nome") String nome);

		

}
