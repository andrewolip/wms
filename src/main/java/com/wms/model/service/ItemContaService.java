package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.ItemConta;
import com.wms.model.repository.ItemContaRepository;

@Service
public class ItemContaService {
	private ItemContaRepository itemContaRepository;

	@Autowired
	public void setItemContaRepository(ItemContaRepository itemContaRepository) {
		this.itemContaRepository = itemContaRepository;
	}

	public void salvarLista(Collection<ItemConta> itensConta) {
		this.itemContaRepository.save(itensConta);
	}

	public Collection<ItemConta> listarItensPorContaPagar(Integer id) {
		return this.itemContaRepository.findByContaPagarIdContaPagar(id);
	}
	
	public void remover(Integer id) {
		this.itemContaRepository.delete(id);
	}

}
