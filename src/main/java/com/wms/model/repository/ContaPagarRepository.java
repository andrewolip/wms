package com.wms.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.ContaPagar;
import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;

public interface ContaPagarRepository extends CrudRepository<ContaPagar, Integer>{
	
	List<ContaPagar> findByObra(Obra obra);
	List<ContaPagar> findByUnidadeObra(UnidadeObra unidadeObra);
	
}
