package com.wms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Cliente;
import com.wms.model.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public Cliente buscar(@RequestBody Cliente cliente) {
		return this.clienteService.buscarCliente(cliente.getIdCliente());
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Cliente cliente) {
		clienteService.salvar(cliente);
	}

	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Cliente cliente) {
		clienteService.remover(cliente.getIdCliente());
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<Cliente> findAll() {
		return clienteService.listarClientes();
	}
}
