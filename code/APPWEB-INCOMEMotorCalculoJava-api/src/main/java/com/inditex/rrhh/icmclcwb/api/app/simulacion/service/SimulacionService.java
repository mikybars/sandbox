package com.inditex.rrhh.icmclcwb.api.app.simulacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotNull;

public interface SimulacionService {

  void mergeEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergeEstructurasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergePresenciasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergePresenciasEmpleadosTiendaUltimoCalculo(@NotNull TareaDto tarea);

  void mergePresenciaTiendaUltimoCalculo(@NotNull TareaDto tarea);

  void mergeVentaUltimoCalculo(@NotNull TareaDto tarea);

  SimulacionDto findbyId(@NotNull Long id);

  void updateBandaExcepcionada(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion);

  void mergePresenciaEmpleadoUltimoCalculoOtraTienda(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion,
      @NotNull String tiendaPresenciaUltimoCalculo);

  void mergePresenciasEmpleadoIntoPresenciasTotalesTiendaSimulada(@NotNull TareaDto tarea, @NotNull SimulacionDto simulacion);

  List<String> findTiendasPresenciasEmpleadoUltimoCalculo(@NotNull RunTareaDto runTareaDto);
}
