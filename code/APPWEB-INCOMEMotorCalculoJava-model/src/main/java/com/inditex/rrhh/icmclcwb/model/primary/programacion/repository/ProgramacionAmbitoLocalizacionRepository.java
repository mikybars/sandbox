package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionAmbitoLocalizacionRepository extends BaseRepository<ProgramacionAmbitoLocalizacion, Long> {

  List<ProgramacionAmbitoLocalizacion> findByProgramacionAmbitoId(Long programacionAmbitoId);

}
