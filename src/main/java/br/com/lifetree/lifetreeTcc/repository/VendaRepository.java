package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
