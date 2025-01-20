package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.cache.annotation.Cacheable;

public interface TareaPersonaHistoricoService {

  List<TareaPersonaHistoricoDto> merge(
      @Valid @NonNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaPersonaHistoricoDto> mergeEmpleadoDtos(
      @Valid @NonNull @NotEmpty final List<EmpleadoDTO> genericEmpleadoResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  List<TareaPersonaHistoricoDto> save(
      @Valid @NonNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NonNull final Long idTarea,
      @NonNull final String cclIdOrigen, @NonNull final List<Integer> idsTipoDato);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NonNull final Long idTarea,
      @NonNull final String cclIdOrigen);

  PeriodoDto findPeriodoByIdTareaDto(@NonNull final Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NonNull final Long idTarea);

  List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(@NonNull final Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NonNull final Long idTarea,
      @NonNull final String cclIdOrigen);

  @Cacheable(value = "itx.icmlcwb.id_persona_historico_localizacion_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NonNull Long idTarea,
      @NonNull String cclIdOrigen);
}
