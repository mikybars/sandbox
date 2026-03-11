package com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface SimulacionRepositoryCustom {

  void mergeEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergeEstructurasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergePresenciasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void mergeVentaUltimoCalculo(@NotNull TareaDto tarea);

  void mergePresenciaTiendaUltimoCalculo(@NotNull TareaDto tarea);

  void mergePresenciasEmpleadosTiendaUltimoCalculo(@NotNull TareaDto tarea);

  List<TareaPersonaEstructuraDto> findEstructurasEmpleadoSimulacion(@NotNull TareaDto tarea);

  void updateBandaExcepcionada(@NotNull TareaDto tarea, @NotNull Integer banda, @NotEmpty String cclIdCodOrigen,
      @NotEmpty String cclIdSeccion);

  void mergePresenciaEmpleadoUltimoCalculoOtraTienda(@NotNull TareaDto tarea, @NotEmpty String cclIdPerson,
      @NotEmpty String cclIdCodOrigen, @NotNull String tiendaPresenciaUltimoCalculo);

  void mergePresenciasEmpleadoIntoPresenciasTotalesTiendaSimulada(@NotNull TareaDto tarea, @NotEmpty String cclIdPerson);
}
