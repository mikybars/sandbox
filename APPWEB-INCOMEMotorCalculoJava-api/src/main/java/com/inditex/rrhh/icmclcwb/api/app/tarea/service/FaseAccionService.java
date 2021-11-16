
package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface FaseAccionService {

  /**
   * @param idFase
   * @return
   */
  List<FaseAccionDto> findByIdFase(@NotNull @Positive Integer idFase);

}
