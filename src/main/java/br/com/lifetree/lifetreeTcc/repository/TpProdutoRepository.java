package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.TpProduto;

@Repository
public interface TpProdutoRepository extends JpaRepository<TpProduto, Long> {
	
	TpProduto findByTpProduto(String TpProduto);

}
