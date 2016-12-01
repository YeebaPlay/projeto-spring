package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.v1.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	List<Veiculo> findAll();
	
	@Query("SELECT v FROM #{#entityName} v WHERE v.categoria.id = :id")
	List<Veiculo> findByCategoria(@Param("id") Integer id);
}
