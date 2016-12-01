package org.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Locacao;
import org.v1.repository.LocacaoRepository;

@RestController
@RequestMapping("/locacao")
public class LocacaoController extends BatchController<Locacao, Integer> {

	private LocacaoRepository locacaoRepository;
	@Autowired
	public LocacaoController(LocacaoRepository rep) {
		super(rep);
		locacaoRepository = rep;
	}
	
	@RequestMapping(value="/find/by/funcionario/{id}")
	public List<Locacao> findByFuncionario(@PathVariable("id") Integer id) {
		return locacaoRepository.findByFuncionario(id);
	}
	
	@RequestMapping(value="/find/by/veiculo/{id}")
	public List<Locacao> findByVeiculo(@PathVariable("id") Integer id) {
		return locacaoRepository.findByVeiculo(id);
	}
}
