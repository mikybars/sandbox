package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AccionRepositoryCustom {

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
