package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Pais;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface PaisRepository extends BaseRepository<Pais, Short> {

	@Query(value = "SELECT ID_PAIS, DESCRIPCION FROM MAESTROS.PAIS FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
	Collection<Pais> findAllQuery();

}