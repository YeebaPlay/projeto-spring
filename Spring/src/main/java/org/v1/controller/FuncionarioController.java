package org.v1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.v1.domain.Funcionario;
import org.v1.domain.Locacao;
import org.v1.repository.FuncionarioRepository;
import org.v1.repository.LocacaoRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired	private FuncionarioRepository rep;
	@Autowired private LocacaoRepository locaRep;
	
	@RequestMapping
	public List<Funcionario> all() {
		List<Funcionario> request = rep.findAll();
		return request;
	}
	
//	insert into Funcionario (idfuncionario, matricula, nome) values (1, 'A120', 'Ronaldo');
	
	@RequestMapping(value="/save")
	public Map<String, Object> save(@RequestBody Funcionario funcionario) {
		rep.save(funcionario);
		Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        return m;
	}
	
	@RequestMapping(value="/delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") Integer id) {
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			rep.delete(id);
	        m.put("success", true);
		}catch (Exception e) {
			m.put("conflito", true);
		}
		return m;
	}
	
	@RequestMapping(value="/{id}")
	public Funcionario findById(@PathVariable("id") Integer id) {
		return rep.findOne(id);
	}
	
	@RequestMapping(value="/{id}/locacao_cad")
	public List<Locacao> findByFuncCad(@PathVariable("id") Integer id) {
		return locaRep.findByFuncCad(id);
	}
	
	@RequestMapping(value="/{id}/locacao_rec")
	public List<Locacao> findByFuncRec(@PathVariable("id") Integer id) {
		return locaRep.findByFuncRec(id);
	}
}
