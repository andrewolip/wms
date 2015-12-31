package com.wms.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.UnidadeObra;

public interface UnidadeObraRepository extends CrudRepository<UnidadeObra, Integer>{

	List<UnidadeObra> findByNomeObra(String nomeObra);
	
}
