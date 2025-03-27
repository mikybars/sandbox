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
import jakarta.validation.constraints.NotNull;
import org.springframework.cache.annotation.Cacheable;

public interface TareaPersonaHistoricoService {

  List<TareaPersonaHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  List<TareaPersonaHistoricoDto> mergeEmpleadoDtos(
      @Valid @NotNull @NotEmpty final List<EmpleadoDTO> genericEmpleadoResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  List<TareaPersonaHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NotNull final Long idTarea,
      @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
      @NotNull final String cclIdOrigen);

  PeriodoDto findPeriodoByIdTareaDto(@NotNull final Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull final Long idTarea);

  List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(@NotNull final Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NotNull final Long idTarea,
      @NotNull final String cclIdOrigen);

  @Cacheable(value = "itx.icmlcwb.id_persona_historico_localizacion_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull Long idTarea,
      @NotNull String cclIdOrigen);
}
