package com.inditex.rrhh.icmclcwb.api.app.simulacion.service;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotNull;

public interface SimulacionService {

  void mergeEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergeEstructurasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergePresenciasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergePresenciaEmpleadoUltimoCalculo(@NotNull TareaDto tarea);

  void mergePresenciaTiendaUltimoCalculo(@NotNull TareaDto tarea);

  void mergeVentaUltimoCalculo(@NotNull TareaDto tarea);

  SimulacionDto findbyId(@NotNull Long id);

  void updateBandaExcepcionada(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion);

  void updateTiendaPersonaPresencia(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion);

  void mergePresenciaTiendaSimulada(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion);
}
