package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaValidarRepositoryCustom {

  List<String> checkDuplicatedTiendasHistorico(@NonNull @Positive Long idTarea);

  List<String> validateAmbitoEmpresa(@NonNull @Positive Long idTarea);

  List<String> validateAmbitoPersona(@NonNull @Positive Long idTarea);

  List<String> validateAmbitoLocalizacion(@NonNull @Positive Long idTarea);

  Integer countEmpleadosHistorico(@NonNull @Positive Long idTarea);

  Integer countTiendasHistorico(@NonNull @Positive Long idTarea);

  Integer countEstructuras(@NonNull @Positive Long idTarea);

  Integer countTiendaPresenciaSeccion(@NonNull @Positive Long idTarea);

  Integer countTiendaEmpleadoPresenciaSeccion(@NonNull @Positive Long idTarea);

  Integer countTiendaVentaSeccion(@NonNull @Positive Long idTarea);

  List<TareaPersonaHistoricoDto> empleadoHistoricoEmptyFields(@NonNull @Positive Long idTarea);

  List<String> checkDuplicatedTiposHora(@NonNull @Positive Long idTarea);

}
