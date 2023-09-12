package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbito;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionAmbitoRepository extends BaseRepository<ProgramacionAmbito, Long> {

  List<ProgramacionAmbito> findByProgramacionId(Long programacionId);

}
