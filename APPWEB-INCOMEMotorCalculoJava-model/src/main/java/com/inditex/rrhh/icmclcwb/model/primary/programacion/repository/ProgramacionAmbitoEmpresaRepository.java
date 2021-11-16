package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.ProgramacionAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProgramacionAmbitoEmpresaRepository extends BaseRepository<ProgramacionAmbitoEmpresa, Long> {

  List<ProgramacionAmbitoEmpresa> findByProgramacionAmbitoId(Long programacionAmbitoId);

}
