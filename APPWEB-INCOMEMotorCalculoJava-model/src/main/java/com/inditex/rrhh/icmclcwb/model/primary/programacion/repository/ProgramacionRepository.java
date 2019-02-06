package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.Date;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionRepository extends BaseRepository<Programacion, Long> {

	List<Programacion> findByFechaSiguienteEjecucionBeforeAndActivaTrue(Date fechaSiguienteEjecucion);

}