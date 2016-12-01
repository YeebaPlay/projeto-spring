package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.v1.domain.Avaria;

public interface AvariaRepository extends JpaRepository<Avaria, Integer>{
	List<Avaria> findAll();

	@Query("SELECT a FROM #{#entityName} a INNER JOIN a.locacoes l WHERE l.id = :id")
	List<Avaria> findByLocacao(@Param("id") Integer id);
}
