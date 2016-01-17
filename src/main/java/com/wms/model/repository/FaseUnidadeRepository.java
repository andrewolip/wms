package com.wms.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Fase;
import com.wms.model.entity.FaseUnidade;

public interface FaseUnidadeRepository extends CrudRepository<FaseUnidade, Integer>{
	
	List<FaseUnidade> findByUnidadeObraIdUnidadeObra(Integer id);
}
