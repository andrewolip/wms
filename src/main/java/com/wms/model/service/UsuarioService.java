package com.wms.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.entity.Usuario;
import com.wms.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    public void setFuncaoRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
 
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void remover(Integer id) {
		usuarioRepository.delete(id);
	}
	
	public Collection<Usuario> listarUsuarios() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Integer id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario buscarUsuario(Integer id) {
		return usuarioRepository.findOne(id);
	}

//	@Query("select c.nome from Usuario c where c.perfil = '2'")
	public Collection<Usuario> listarCoordenadores() {
		return (Collection<Usuario>) usuarioRepository.findByPerfil(2);
	}
	
}
