package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.v1.domain.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Integer>{
	List<Locacao> findAll();

	@Query("SELECT l FROM #{#entityName} l WHERE l.funcionarioCad.id = :id")
	List<Locacao> findByFuncionario(@Param("id") Integer id);

	@Query("SELECT l FROM #{#entityName} l WHERE l.veiculo.id = :id")
	List<Locacao> findByVeiculo(@Param("id") Integer id);
	
	@Query("SELECT l FROM #{#entityName} l WHERE l.funcionarioCad.id = :id")
	List<Locacao> findByFuncCad(@Param("id") Integer id);
	
	@Query("SELECT l FROM #{#entityName} l WHERE l.funcionarioRec.id = :id")
	List<Locacao> findByFuncRec(@Param("id") Integer id);
}
