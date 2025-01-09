package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionHistoricoService {

  List<TareaLocalizacionHistoricoDto> save(
      @Valid @NonNull @NotEmpty final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico);

  List<TareaLocalizacionHistoricoDto> merge(
      @Valid @NonNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NonNull final TareaDto tarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen,
      @NonNull final Long idVentaConcepto);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen,
      @NonNull final List<Long> idVentaConcepto);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(@NonNull final Long idTarea,
      @NotBlank final String cclIdOrigen, @NotBlank String stdIdLegEnt, @NonNull final Long idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NonNull @Positive final Long idTarea, @NotBlank String cclCodOrigen, @NonNull List<String> idTipoCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByIdTarea(@NonNull @Positive final Long idTarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt,
      @NonNull final List<String> idTipoCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByStdIdLegEntAndIdTarea(
      @NonNull @NotEmpty final List<String> stdIdLegEnt,
      @NonNull @Positive final Long idTarea,
      @NonNull @NotEmpty List<Long> idTipoConceptoVentaChallenge);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
      @NonNull @Positive Long idTarea, @NonNull @Positive Integer idTipoPresupuesto,
      @NonNull LocalDate fechaInicio, @NonNull LocalDate fechaFin);

  List<IdLocalizacionDto> findIdLocalizacionByIdTarea(
      @NonNull @Positive Long idTarea);

  void mergeLocalizacionFicticia(@NonNull Long idTarea, @NonNull String cclIdOrigen, @NotBlank String stdIdLegEnt);

  List<IdLocalizacionLocalDto> findLocalizacionFicticiaByIdOrigenAndIdEmpresa(@NonNull String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

  List<IdLocalizacionEmpresaDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NonNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NonNull @NotEmpty List<String> stdIdLegEnt);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(@NonNull Long idTarea,
      @NotBlank String cclIdOrigen, @NonNull List<Long> idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(@NonNull Long idTarea,
      @NotBlank String cclIdOrigen, @NonNull List<String> idsCadena);

}
