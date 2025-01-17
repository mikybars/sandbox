package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaValidarService {

  List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea);

  Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea);

  Integer countTiendasHistorico(@NotNull @Positive Long idTarea);

  Integer countEstructuras(@NotNull @Positive Long idTarea);

  Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea);

  Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea);

  Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea);

  Map<String, Object> validateByIdTarea(@NotNull @Positive Long idTarea);

  List<Map<String, Object>> validateByIdTrabajo(@NotNull @Positive Long idTrabajo);

  List<String> validateAmbito(@NotNull @Positive Long idTarea);

  List<String> checkDuplicatedTiposHora(@NotNull @Positive Long idTarea);

}
