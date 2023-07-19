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
		@Query("SELECT * FROM Produto")
		List<Produto> ListarTodosProd();
		
		@Query("SELECT * FROM Produto  WHERE Nome like %??%")
		List<Produto> listarProdutosFiltro(@Param("nome") String nome);
	

}
