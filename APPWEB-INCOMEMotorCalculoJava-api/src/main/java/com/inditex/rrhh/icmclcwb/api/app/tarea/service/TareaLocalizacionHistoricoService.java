package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

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

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotBlank final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
            @NotBlank final String cclIdOrigen,
            @NotNull final Long idVentaConcepto);

    List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
            @NotBlank final String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
            @NotNull @Positive final Long idTarea, @NotBlank String cclCodOrigen, @NotNull List<String> idTipoCalculo);

    List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByIdTarea(@NotNull @Positive final Long idTarea);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull @NotEmpty final List<String> stdIdLegEnt);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
            @NotNull @NotEmpty final List<String> stdIdLegEnt,
            @NotNull final List<String> idTipoCalculo);

    List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByStdIdLegEntAndIdTarea(
            @NotNull @NotEmpty final List<String> stdIdLegEnt,
            @NotNull @Positive final Long idTarea);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
            @NotNull @Positive final Long idTarea,
            @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull @NotEmpty final List<String> stdIdLegEnt);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
            @NotNull @Positive Long idTarea, @NotNull @Positive Integer idTipoPresupuesto,
            @NotNull LocalDate fechaInicio, @NotNull LocalDate fechaFin);

    void mergeLocalizacionFicticia(@NotNull Long idTarea, @NotNull String cclIdOrigen);

}
