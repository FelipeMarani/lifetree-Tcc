package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CupomRepository extends JpaRepository<CupomRepository, Long> {

}
