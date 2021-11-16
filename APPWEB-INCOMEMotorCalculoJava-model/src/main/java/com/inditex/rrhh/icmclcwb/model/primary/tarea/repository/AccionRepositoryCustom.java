
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AccionRepositoryCustom {

  /**
   * @param idAccion
   * @param cclIdOrigen
   * @param stdIdLegEnt
   * @return
   */
  Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive Integer idAccion, @NotBlank String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

}
