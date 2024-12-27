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
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaPersonaHistoricoRepositoryCustom {

  List<TareaPersonaHistorico> save(List<TareaPersonaHistorico> src);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NonNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen, @NonNull List<Integer> idsTipoDato);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NonNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  PeriodoDto findPeriodoDtoByIdTarea(@NonNull @Positive Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NonNull @Positive Long idTarea);

  List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(@NonNull @Positive Long idTarea);

  List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NonNull @Positive Long idTarea, @NonNull String cclIdOrigen,
      @NonNull TipoVentaConceptoEnum tipoVentaConcepto);

  List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdsTiposDato(
      @NonNull List<Integer> idsTipoDato);

  List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NonNull @Positive Long idTarea, @NotBlank String cclIdOrigen);
}
