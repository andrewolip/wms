package com.wms.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wms.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	List<Usuario> findByPerfil(int perfil);
}
