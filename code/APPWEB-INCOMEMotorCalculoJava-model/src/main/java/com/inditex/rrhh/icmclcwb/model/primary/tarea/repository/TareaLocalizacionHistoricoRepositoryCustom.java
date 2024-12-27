package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionHistoricoRepositoryCustom {

  List<TareaLocalizacionHistorico> save(List<TareaLocalizacionHistorico> src);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NonNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
      @NonNull @Positive Long idTarea,
      @NotBlank String cclIdOrigen);

  List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen,
      List<Long> idsVentaConcepto);

  List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen);

  List<IdCadenaDto> getCadenasByTareaAndOrigenAndEmpresa(final Long idTarea, final String cclIdOrigen,
      final String stdIdLegEnt, List<Long> idsVentaConcepto);

  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NonNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NonNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NonNull @Positive Long idTarea, @NotBlank String cclCodOrigen, @NonNull List<String> tiposCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
      @NonNull @Positive final Long idTarea);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NonNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NonNull @NotEmpty final List<String> stdIdLegEnt, @NonNull List<String> tiposCalculo);

  List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea(
      @NonNull @NotEmpty final List<String> stdIdLegEnt, @NonNull @Positive final Long idTarea,
      @NonNull @NotEmpty final List<Long> idTipoConceptoVentaChallenge);

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

  List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(Long idTarea, String cclIdOrigen,
      List<Long> idVentaConcepto);

  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
      @NonNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NonNull List<String> idsCadena);

}
