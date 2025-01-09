package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaValidarService {

  List<String> checkDuplicatedTiendasHistorico(@NonNull @Positive Long idTarea);

  Integer countEmpleadosHistorico(@NonNull @Positive Long idTarea);

  Integer countTiendasHistorico(@NonNull @Positive Long idTarea);

  Integer countEstructuras(@NonNull @Positive Long idTarea);

  Integer countTiendaPresenciaSeccion(@NonNull @Positive Long idTarea);

  Integer countTiendaEmpleadoPresenciaSeccion(@NonNull @Positive Long idTarea);

  Integer countTiendaVentaSeccion(@NonNull @Positive Long idTarea);

  Map<String, Object> validateByIdTarea(@NonNull @Positive Long idTarea);

  List<Map<String, Object>> validateByIdTrabajo(@NonNull @Positive Long idTrabajo);

  List<String> validateAmbito(@NonNull @Positive Long idTarea);

  List<String> checkDuplicatedTiposHora(@NonNull @Positive Long idTarea);

}
