package org.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Veiculo;
import org.v1.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController extends BatchController<Veiculo, Integer> {

	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoController(VeiculoRepository rep) {
		super(rep);
		veiculoRepository = rep;
	}

	@RequestMapping(value = "/find/by/categoria/{id}")
	public List<Veiculo> findByCategoria(@PathVariable("id") Integer id) {
		return veiculoRepository.findByCategoria(id);
	}
}
