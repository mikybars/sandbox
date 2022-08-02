package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface TareaLocalizacionHistoricoRepositoryCustom {

  List<TareaLocalizacionHistorico> save(List<TareaLocalizacionHistorico> src);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
      @NotNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen,
      List<Long> idsVentaConcepto);

  List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen);

    List<IdCadenaDto> getCadenasByTareaAndOrigenAndEmpresa(final Long idTarea, final String cclIdOrigen,
        final String stdIdLegEnt, List<Long> idsVentaConcepto);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive Long idTarea, @NotBlank String cclCodOrigen, @NotNull List<String> tiposCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
      @NotNull @Positive final Long idTarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt, @NotNull List<String> tiposCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea(
      @NotNull @NotEmpty final List<String> stdIdLegEnt, @NotNull @Positive final Long idTarea,
      @NotNull @NotEmpty final List<Long> idTipoConceptoVentaChallenge);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
      @NotNull @Positive Long idTarea, @NotNull @Positive Integer idTipoPresupuesto,
      @NotNull LocalDate fechaInicio, @NotNull LocalDate fechaFin);

  void mergeLocalizacionFicticia(@NotNull Long idTarea, @NotNull String cclIdOrigen, @NotBlank String stdIdLegEnt);

  List<IdLocalizacionLocalDto> findLocalizacionFicticiaByIdOrigenAndIdEmpresa(@NotNull String cclIdOrigen,
      @NotBlank String stdIdLegEnt);

  List<IdLocalizacionEmpresaDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NotNull @NotEmpty List<String> stdIdLegEnt);

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(Long idTarea, String cclIdOrigen,
      List<Long> idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
      @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NotNull List<String> idsCadena);

}
