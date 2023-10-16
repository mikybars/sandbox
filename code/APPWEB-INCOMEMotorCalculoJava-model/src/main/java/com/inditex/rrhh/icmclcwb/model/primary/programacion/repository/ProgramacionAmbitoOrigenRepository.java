package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoOrigen;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionAmbitoOrigenRepository extends BaseRepository<ProgramacionAmbitoOrigen, Long> {

  List<ProgramacionAmbitoOrigen> findByProgramacionAmbitoId(Long programacionAmbitoId);

}
