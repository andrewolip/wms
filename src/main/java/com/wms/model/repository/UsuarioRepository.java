package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	Collection<Usuario> findByPerfil(int perfil);
}
