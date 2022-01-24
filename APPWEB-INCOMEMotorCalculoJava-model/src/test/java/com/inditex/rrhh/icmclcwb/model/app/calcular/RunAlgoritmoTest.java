/*
 * Copyright (c) 2021. Inditex
 */
package com.inditex.rrhh.icmclcwb.model.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

/**
 * Clase para contener ciertos métodos de creación de objetos comunes en los tests de algoritmos.
 */
public interface RunAlgoritmoTest {

  public default RunAlgoritmoCalculoPropertiesDto createRunAlgoritmoCalculoPropertiesDto(final int batchSize) {
    final RunAlgoritmoCalculoPropertiesDto properties = new RunAlgoritmoCalculoPropertiesDto();
    properties.setBatchSize(batchSize);
    properties.setThreadSize(3);
    return properties;
  }

  public default RunTareaDto createRunTareaDto(final Long idTarea, final Long idTrabajo) {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(idTrabajo);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);
    return runTarea;
  }

}
