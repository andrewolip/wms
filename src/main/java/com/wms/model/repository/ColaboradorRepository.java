package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Colaborador;

public interface ColaboradorRepository extends CrudRepository<Colaborador, Integer>{
	Collection<Colaborador> findByObraIdObra(Integer id);
}	
