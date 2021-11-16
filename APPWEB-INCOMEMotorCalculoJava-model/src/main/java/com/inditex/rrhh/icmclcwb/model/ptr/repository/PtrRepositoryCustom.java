package com.inditex.rrhh.icmclcwb.model.ptr.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PtrRepositoryCustom {

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @param ambito Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFecha(TareaDto tarea, TareaAmbitoDto ambito);

  /**
   * Some javadoc.
   *
   * @param tarea Some javadoc.
   * @param ambito Some javadoc.
   * @param idCatalogoAplicacion Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFechaEs(TareaDto tarea, TareaAmbitoDto ambito,
      Integer idCatalogoAplicacion);

}
