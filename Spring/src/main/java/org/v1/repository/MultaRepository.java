package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.v1.domain.Multa;

public interface MultaRepository extends JpaRepository<Multa, Integer>{
	List<Multa> findAll();
	
	@Query("SELECT m FROM #{#entityName} m INNER JOIN m.locacoes l WHERE l.id = :id")
	List<Multa> findByLocacao(@Param("id") Integer id);
}
