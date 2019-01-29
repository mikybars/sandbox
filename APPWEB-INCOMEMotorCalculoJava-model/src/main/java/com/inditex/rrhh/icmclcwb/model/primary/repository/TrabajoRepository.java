package com.inditex.rrhh.icmclcwb.model.primary.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoRepository extends BaseRepository<Trabajo, Long> {

	@Transactional
	@Modifying
	@Query("update Trabajo u set u.estado.id = ?2 where u.id = ?1")
	int updateEstadoTrabajo(Long id, Long estado);
	
}