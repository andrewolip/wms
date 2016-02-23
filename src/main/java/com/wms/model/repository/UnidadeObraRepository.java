package com.wms.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.entity.UnidadeObra;

public interface UnidadeObraRepository extends JpaRepository<UnidadeObra, Integer>{

	Collection<UnidadeObra> findByObraIdObra(Integer id);
	
//	@Query("SELECT u.nomeUnidade, f.nomeFase, f.dataInicio, f.dataPrevistaTermino FROM UnidadeObra u JOIN u.fases f WHERE u.obra.idObra = :idObra")
//	Collection<UnidadeObra> listarUnidadesFases(@Param("idObra") Integer idObra);
	
//	@Query("SELECT u.nomeUnidade, f.dataInicio, f.dataPrevistaTermino, f.nomeFase FROM UnidadeObra u JOIN u.fases f WHERE u.obra.idObra = :idObra")
//	Collection<UnidadeObra> listarUnidadesFases(@Param("idObra") Integer idObra);
	
//	@Query("SELECT new com.wms.model.dto.UnidadeDTO(u.nomeUnidade, u.fases) from UnidadeObra u JOIN u.fases f WHERE u.obra.idObra = :idObra")
//	Collection<UnidadeDTO> listarUnidadesFases(@Param("idObra")Integer idObra);
	
}
