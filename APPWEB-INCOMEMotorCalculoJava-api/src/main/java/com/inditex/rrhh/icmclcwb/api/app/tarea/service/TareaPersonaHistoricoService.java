package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaPersonaHistoricoService {

    List<TareaPersonaHistoricoDto> merge(
            @Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
            @Valid @NotNull final TareaDto tarea);

    List<TareaPersonaHistoricoDto> save(
            @Valid @NotNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea,
            @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

    PeriodoDto findPeriodoByIdTareaDto(@NotNull final Long idTarea);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull final Long idTarea);

    List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(@NotNull final Long idTarea);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
            @NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

}
