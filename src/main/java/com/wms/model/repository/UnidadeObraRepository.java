package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.UnidadeObra;

public interface UnidadeObraRepository extends CrudRepository<UnidadeObra, Integer>{

	Collection<UnidadeObra> findByObraIdObra(Integer id);
}
