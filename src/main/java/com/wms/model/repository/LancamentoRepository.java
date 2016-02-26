package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wms.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{
	
	@Query("SELECT l FROM Lancamento l JOIN l.contaPagar cp JOIN cp.obra o WHERE o.idObra = :idObra")
	Collection<Lancamento> listarLancamentosPorObra(@Param("idObra") Integer idObra);
}
