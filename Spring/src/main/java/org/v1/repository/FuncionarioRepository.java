package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.v1.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	List<Funcionario> findAll();

}
