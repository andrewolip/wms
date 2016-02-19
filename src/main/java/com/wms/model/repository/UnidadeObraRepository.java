package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.entity.UnidadeObra;

public interface UnidadeObraRepository extends JpaRepository<UnidadeObra, Integer>{

	Collection<UnidadeObra> findByObraIdObra(Integer id);
	
	
}
