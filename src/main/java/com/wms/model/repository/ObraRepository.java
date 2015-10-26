package com.wms.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Obra;

public interface ObraRepository extends CrudRepository<Obra, Integer> {
	
	List<Obra> findByNome(String nome);
	
}
