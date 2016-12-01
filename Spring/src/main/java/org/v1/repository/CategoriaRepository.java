package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.v1.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	List<Categoria> findAll();
}
