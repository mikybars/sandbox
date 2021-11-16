
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface AccionService {

  /**
   * @param id
   * @return
   */
  AccionDto findAccionDtoById(@NotNull Integer id);

  /**
   * @param idAccion
   * @param cclIdOrigen
   * @param stdIdLegEnt
   * @return
   */
  Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive Integer idAccion, @NotBlank String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

}
