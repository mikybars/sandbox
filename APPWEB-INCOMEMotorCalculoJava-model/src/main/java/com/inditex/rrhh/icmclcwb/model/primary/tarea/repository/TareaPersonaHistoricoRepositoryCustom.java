package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

public interface TareaPersonaHistoricoRepositoryCustom {

    List<TareaPersonaHistorico> save(List<TareaPersonaHistorico> src);

    List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull @Positive Long idTarea,
            @NotNull @Positive String cclIdOrigen);

    List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigenInPeriodoCalculoPersona(@NotNull @Positive Long idTarea,
            @NotNull @Positive String cclIdOrigen);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull @Positive Long idTarea,
            @NotBlank String cclIdOrigen, @NotNull List<Integer> idsTipoDato);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull @Positive Long idTarea,
            @NotBlank String cclIdOrigen);

    PeriodoDto findPeriodoDtoByIdTarea(@NotNull @Positive Long idTarea);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull @Positive Long idTarea);

}
