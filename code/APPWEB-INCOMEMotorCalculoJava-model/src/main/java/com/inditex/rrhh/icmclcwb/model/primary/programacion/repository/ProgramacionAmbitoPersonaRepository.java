package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionAmbitoPersonaRepository extends BaseRepository<ProgramacionAmbitoPersona, Long> {

  List<ProgramacionAmbitoPersona> findByProgramacionAmbitoId(Long programacionAmbitoId);

}
