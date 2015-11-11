package com.wms.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
