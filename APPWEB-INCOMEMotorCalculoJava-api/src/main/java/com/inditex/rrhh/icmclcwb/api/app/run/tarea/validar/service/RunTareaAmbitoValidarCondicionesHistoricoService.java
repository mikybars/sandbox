
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import javax.validation.Valid;

public interface RunTareaAmbitoValidarCondicionesHistoricoService {

  /**
   * @param runTarea
   * @param tareaAmbito
   * @return
   */
  ValidacionDto execute(@Valid RunTareaDto runTarea, @Valid TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion);

}
