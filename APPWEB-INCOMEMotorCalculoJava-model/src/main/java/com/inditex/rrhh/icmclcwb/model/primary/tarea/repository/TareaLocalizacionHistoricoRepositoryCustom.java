package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

public interface TareaLocalizacionHistoricoRepositoryCustom {

    List<TareaLocalizacionHistorico> save(List<TareaLocalizacionHistorico> src);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull @Positive Long idTarea,
            @NotBlank String cclIdOrigen);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NotNull List<Integer> idsTipoDato);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
            @NotNull @Positive Long idTarea,
            @NotBlank String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen, @NotNull List<Integer> idsTipoDato);

    List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen, Long idsVentaConcepto);

    List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
            @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
            @NotNull @Positive Long idTarea, @NotBlank String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
            @NotNull @Positive Long idTarea, @NotBlank String cclCodOrigen, @NotNull List<String> tiposCalculo);

    List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
            @NotNull @Positive final Long idTarea);

    List<IdLocalizacionLocalDto> findTiendasGrupoFechasByIdTarea(@NotNull @Positive final Long idTarea);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
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

}
