package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.ItemConta;

public interface ItemContaRepository  extends CrudRepository<ItemConta, Integer>{
	Collection<ItemConta> findByContaPagarIdContaPagar(Integer id);
}
