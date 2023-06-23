package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.Cupom;


@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

}
