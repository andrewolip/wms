package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Obra;
import com.wms.model.repository.ObraRepository;

@RestController
@RequestMapping(value = "/obra")
public class ObraController {

	@Autowired
	private ObraRepository obraRepository;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void inserir(@RequestBody Obra obra) {
		obraRepository.save(obra);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Obra create(@RequestBody Obra obra) {
		return obraRepository.save(obra);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizar(@RequestBody Obra obra) {

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete() {

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Obra> findAll() {
		return (List<Obra>) obraRepository.findAll();
	}

}
