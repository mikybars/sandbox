package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface AccionRepositoryCustom {

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
