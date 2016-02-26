package com.wms.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{

}
