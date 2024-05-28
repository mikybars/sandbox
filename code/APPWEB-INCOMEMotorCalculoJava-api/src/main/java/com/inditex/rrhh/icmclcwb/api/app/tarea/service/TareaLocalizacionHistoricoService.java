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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface TareaLocalizacionHistoricoService {

  List<TareaLocalizacionHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico);

  List<TareaLocalizacionHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NotNull final TareaDto tarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen,
      @NotNull final Long idVentaConcepto);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen,
      @NotNull final List<Long> idVentaConcepto);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen, @NotBlank String stdIdLegEnt, @NotNull final Long idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank String cclCodOrigen, @NotNull List<String> idTipoCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByIdTarea(@NotNull @Positive final Long idTarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt,
      @NotNull final List<String> idTipoCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByStdIdLegEntAndIdTarea(
      @NotNull @NotEmpty final List<String> stdIdLegEnt,
      @NotNull @Positive final Long idTarea,
      @NotNull @NotEmpty List<Long> idTipoConceptoVentaChallenge);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
      @NotNull @Positive Long idTarea, @NotNull @Positive Integer idTipoPresupuesto,
      @NotNull LocalDate fechaInicio, @NotNull LocalDate fechaFin);

  List<IdLocalizacionDto> findIdLocalizacionByIdTarea(
      @NotNull @Positive Long idTarea);

  void mergeLocalizacionFicticia(@NotNull Long idTarea, @NotNull String cclIdOrigen, @NotBlank String stdIdLegEnt);

  List<IdLocalizacionLocalDto> findLocalizacionFicticiaByIdOrigenAndIdEmpresa(@NotNull String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

  List<IdLocalizacionEmpresaDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NotNull @NotEmpty List<String> stdIdLegEnt);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(@NotNull Long idTarea,
      @NotBlank String cclIdOrigen, @NotNull List<Long> idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(@NotNull Long idTarea,
      @NotBlank String cclIdOrigen, @NotNull List<String> idsCadena);

}
