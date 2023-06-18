package br.com.lifetree.lifetreeTcc.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
	
}
