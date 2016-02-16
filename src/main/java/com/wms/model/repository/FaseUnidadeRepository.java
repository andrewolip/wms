package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.FaseUnidade;

public interface FaseUnidadeRepository extends CrudRepository<FaseUnidade, Integer>{
	
	Collection<FaseUnidade> findByUnidadeObraIdUnidadeObra(Integer id);
}
