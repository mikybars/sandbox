package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AccionService {

  /**
   * Some javadoc.
   *
   * @param id Some javadoc.
   * @return Some javadoc.
   */
  AccionDto findAccionDtoById(@NonNull Integer id);

  /**
   * Some javadoc.
   *
   * @param idAccion Some javadoc.
   * @param cclIdOrigen Some javadoc.
   * @param stdIdLegEnt Some javadoc.
   * @return Some javadoc.
   */
  Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NonNull @Positive Integer idAccion, @NotBlank String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

}
