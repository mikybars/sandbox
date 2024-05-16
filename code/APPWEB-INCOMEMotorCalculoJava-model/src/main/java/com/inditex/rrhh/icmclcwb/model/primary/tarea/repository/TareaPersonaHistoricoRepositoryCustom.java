package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaPersonaHistoricoRepositoryCustom {

  List<TareaPersonaHistorico> save(List<TareaPersonaHistorico> src);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NotNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen, @NotNull List<Integer> idsTipoDato);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  PeriodoDto findPeriodoDtoByIdTarea(@NotNull @Positive Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull @Positive Long idTarea);

  List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(@NotNull @Positive Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NotNull @Positive Long idTarea, @NotNull String cclIdOrigen,
      @NotNull TipoVentaConceptoEnum tipoVentaConcepto);

  List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdsTiposDato(
      @NotNull List<Integer> idsTipoDato);

  List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen);
}
