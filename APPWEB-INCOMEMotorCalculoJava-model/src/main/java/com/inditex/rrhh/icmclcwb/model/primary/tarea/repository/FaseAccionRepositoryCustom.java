
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface FaseAccionRepositoryCustom {

  /**
   * @param idFase
   * @return
   */
  List<FaseAccionDto> findByIdFase(@NotNull @Positive Integer idFase);

}
