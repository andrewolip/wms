package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.ContaPagar;
import com.wms.model.entity.Obra;
import com.wms.model.entity.UnidadeObra;

public interface ContaPagarRepository extends CrudRepository<ContaPagar, Integer>{
	
	Collection<ContaPagar> findByObra(Obra obra);
	Collection<ContaPagar> findByUnidadeObra(UnidadeObra unidadeObra);
	ContaPagar findByNotaFiscal(Long notaFiscal);
}
