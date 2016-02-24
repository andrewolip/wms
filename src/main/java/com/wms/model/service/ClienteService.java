package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Cliente;
import com.wms.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
    public void setFuncaoRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
 
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void remover(Integer id) {
		clienteRepository.delete(id);
	}
	
	public Collection<Cliente> listarClientes() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente getCliente(Integer id) {
		return clienteRepository.findOne(id);
	}

	public Cliente buscarCliente(Integer id) {
		return clienteRepository.findOne(id);
	}
}
