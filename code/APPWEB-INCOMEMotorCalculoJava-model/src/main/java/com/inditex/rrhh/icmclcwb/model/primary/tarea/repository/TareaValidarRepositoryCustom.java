package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaValidarRepositoryCustom {

  List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea);

  List<String> validateAmbitoEmpresa(@NotNull @Positive Long idTarea);

  List<String> validateAmbitoPersona(@NotNull @Positive Long idTarea);

  List<String> validateAmbitoLocalizacion(@NotNull @Positive Long idTarea);

  Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea);

  Integer countTiendasHistorico(@NotNull @Positive Long idTarea);

  Integer countEstructuras(@NotNull @Positive Long idTarea);

  Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea);

  Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea);

  Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea);

  List<TareaPersonaHistoricoDto> empleadoHistoricoEmptyFields(@NotNull @Positive Long idTarea);

  List<String> checkDuplicatedTiposHora(@NotNull @Positive Long idTarea);

}
