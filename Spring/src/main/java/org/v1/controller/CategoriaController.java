package org.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Categoria;
import org.v1.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends BatchController<Categoria, Integer> {

	@Autowired
	public CategoriaController(CategoriaRepository rep) {
		super(rep);
	}
}
