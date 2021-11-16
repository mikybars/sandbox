package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AccionService {

  /**
   * Some javadoc.
   *
   * @param id Some javadoc.
   * @return Some javadoc.
   */
  AccionDto findAccionDtoById(@NotNull Integer id);

  /**
   * Some javadoc.
   *
   * @param idAccion Some javadoc.
   * @param cclIdOrigen Some javadoc.
   * @param stdIdLegEnt Some javadoc.
   * @return Some javadoc.
   */
  Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive Integer idAccion, @NotBlank String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

}
