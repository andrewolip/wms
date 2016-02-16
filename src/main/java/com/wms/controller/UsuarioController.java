package com.wms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.entity.Usuario;
import com.wms.model.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;
	
	@Autowired
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public Usuario buscar(@RequestBody Usuario usuario) {
		return this.usuarioService.buscarUsuario(usuario.getIdUsuario());
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}

//	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
//	public void delete(@RequestBody Usuario usuario) {
//		usuarioService.remover(usuario.getIdUsuario());
//	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public Collection<Usuario> findAll() {
		return usuarioService.listarUsuarios();
	}

	@RequestMapping(value = "/listar_coordenadores", method = RequestMethod.GET)
	public Collection<Usuario> findAllCoordenadores() {
		return usuarioService.listarCoordenadores();
	}
	
}
