package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lifetree.lifetreeTcc.model.entity.Imagens;

@Repository
public interface ImagensRepository extends JpaRepository<Imagens, Long> {

}
