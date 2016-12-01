package org.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Avaria;
import org.v1.repository.AvariaRepository;

@RestController
@RequestMapping("/avaria")
public class AvariaController extends BatchController<Avaria, Integer> {

	private AvariaRepository avariaRepository;
	
	@Autowired
	public AvariaController(AvariaRepository rep) {
		super(rep);
		avariaRepository = rep;
	}
	
	@RequestMapping(value="/find/by/locacao/{id}")
	public List<Avaria> findByLocacao(@PathVariable("id") Integer id) {
		return avariaRepository.findByLocacao(id);
	}
	
}
