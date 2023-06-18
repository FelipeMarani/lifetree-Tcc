package br.com.lifetree.lifetreeTcc.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface McProdutoRepository extends JpaRepository<McProduto, Long> {

}
