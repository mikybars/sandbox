package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface FaseAccionRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @param idFase Some javadoc.
   * @return Some javadoc.
   */
  List<FaseAccionDto> findByIdFase(@NotNull @Positive Integer idFase);

}
