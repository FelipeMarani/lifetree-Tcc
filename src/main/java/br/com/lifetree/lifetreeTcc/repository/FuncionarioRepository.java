package br.com.lifetree.lifetreeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.lifetree.lifetreeTcc.model.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
<<<<<<< HEAD

=======
>>>>>>> ff40ddaf5f8dfb77d7719c2dabc05992fb6bd951
	Funcionario findByEmail(String email);
	
}
