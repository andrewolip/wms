package com.wms.model.service;

import java.util.List;

import org.hibernate.Query;
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
	
	public List<Usuario> listarUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Integer id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario buscarUsuario(Integer id) {
		return usuarioRepository.findOne(id);
	}

//	@Query("select c.nome from Usuario c where c.perfil = '2'")
	public List<Usuario> listarCoordenadores() {
		return (List<Usuario>) usuarioRepository.findByPerfil(2);
	}
	
}
