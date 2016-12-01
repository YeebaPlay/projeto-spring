package org.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Multa;
import org.v1.repository.MultaRepository;

@RestController
@RequestMapping("/multa")
public class MultaController extends BatchController<Multa, Integer> {

	private MultaRepository multaRepository;
	
	@Autowired
	public MultaController(MultaRepository rep) {
		super(rep);
		multaRepository = rep;
	}
	
	@RequestMapping(value="/find/by/locacao/{id}")
	public List<Multa> findByLocacao(@PathVariable("id") Integer id) {
		return multaRepository.findByLocacao(id);
		
	}
}
