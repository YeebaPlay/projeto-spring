package org.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.v1.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findAll();
	
//	select count(l.id_cliente), l.id_cliente from locacao l inner join cliente c on c.id = l.id_cliente
//			 group by l.id_cliente
	@Query("select COUNT(l.cliente.id), l.cliente.id FROM Locacao l group by l.cliente.id")
	List<Object[]> findByLocacao();

	@Query(value = "SELECT c2.* from cliente c2 where c2.id in (SELECT distinct c.id FROM locacao l inner join cliente c on (c.id = l.id_cliente) WHERE month(date(l.data_locacao)) = :mes)",  nativeQuery = true)
	List<Object[]> findByMesLocacao(@Param("mes") Integer mes);
	
	@Query("SELECT c from Cliente c where c.cpf LIKE :cpf")
	List<Cliente> findByCpf(@Param("cpf") String cpf);
	
}
