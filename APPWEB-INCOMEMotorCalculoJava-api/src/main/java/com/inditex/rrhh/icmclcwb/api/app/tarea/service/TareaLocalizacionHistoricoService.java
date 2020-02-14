package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaLocalizacionHistoricoService {

    List<TareaLocalizacionHistoricoDto> save(@Valid final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico);

    List<TareaLocalizacionHistoricoDto> merge(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotBlank final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea, @NotNull final String cclIdOrigen,
            @NotNull final Long idVentaConcepto);

    List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea, @NotNull final String cclIdOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
        @NotNull @Positive final Long idTarea, @NotBlank String cclCodOrigen, @NotNull List<String> idTipoCalculo);

}
