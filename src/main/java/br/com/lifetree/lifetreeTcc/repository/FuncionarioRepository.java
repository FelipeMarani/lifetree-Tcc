package br.com.lifetree.lifetreeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByEmail(String email);
	
	@Query("SELECT p FROM Funcionario p WHERE p.nome like %?1%")
	List<Funcionario> Filtro(@Param("nome") String nome);
	
	List<Funcionario> findByNomeContaining(String nome);
	
}
