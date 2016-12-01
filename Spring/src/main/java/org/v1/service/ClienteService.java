package org.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.v1.TO.ClienteLocacaoTO;
import org.v1.domain.Cliente;
import org.v1.repository.ClienteRepository;

@Service
public class ClienteService  {

	@Autowired
	private ClienteRepository rep;

	@Transactional(readOnly=true)
	public List<ClienteLocacaoTO> findByLocacao(){

		List<Object[]> locacoes = rep.findByLocacao();
		List<ClienteLocacaoTO> request = new ArrayList<>();
		for (Object[] o : locacoes) {
			Cliente cliente = rep.findOne(Integer.valueOf(o[1].toString()));
			ClienteLocacaoTO clienteLocacaoTO = new ClienteLocacaoTO(Integer.valueOf(o[0].toString()),
					cliente.getNome());
			request.add(clienteLocacaoTO);
		}
		return request;
	
	}

	public List<Object[]> findByMesLocacao(Integer mes) {
		return rep.findByMesLocacao(mes);
	}

	public List<Cliente> findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return rep.findByCpf("%"+cpf+"%");
	}
	
	
	
	
}