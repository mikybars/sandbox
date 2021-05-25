package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepositoryCustom;

@Service
@Validated
public class TareaPersonaHistoricoServiceImpl implements TareaPersonaHistoricoService {

    @Autowired
    private TareaPersonaHistoricoRepository tareaPersonaHistoricoRepository;

    @Autowired
    private TareaPersonaHistoricoRepositoryCustom tareaPersonaHistoricoRepositoryCustom;

    @Autowired
    private TareaPersonaHistoricoMapper tareaPersonaHistoricoMapper;

    @Override
    public List<TareaPersonaHistoricoDto> save(
            @Valid @NotNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico) {
        return this.tareaPersonaHistoricoMapper
            .tareaPersonaHistoricoToTareaPersonaHistoricoDto(
                    this.tareaPersonaHistoricoRepositoryCustom.save(this.tareaPersonaHistoricoMapper
                        .tareaPersonaHistoricoDtoToTareaPersonaHistorico(tareaEmpleadoHistorico)));
    }

    @Override
    public List<TareaPersonaHistoricoDto> merge(
            @Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
            @Valid @NotNull final TareaDto tarea) {
        return this.tareaPersonaHistoricoMapper
            .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(genericEmpleadoResultItemDto, tarea);
    }

    // TODO [COMUN] No se está usando.
    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaByIdTareaAndIdOrigenInAmbito(idTarea,
                cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(
            @NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea,
                cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen_and_tipo_dato",
            key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea,
            @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato) {
        return this.tareaPersonaHistoricoRepositoryCustom
            .findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.periodo_by_tarea", key = "{#idTarea}")
    public PeriodoDto findPeriodoByIdTareaDto(@NotNull final Long idTarea) {
        return this.tareaPersonaHistoricoRepositoryCustom.findPeriodoDtoByIdTarea(idTarea);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_historico_grupo_fechas_by_tarea", key = "{#idTarea}")
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull final Long idTarea) {
        return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);
    }

    @Override
    public List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(
            @NotNull final Long idTarea) {
        return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
    }

    // TODO [COMUN] No se está usando.
    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return this.tareaPersonaHistoricoRepository.findIdPersonaHistoricoByIdTareaAndIdOrigen(idTarea, cclIdOrigen);
    }

    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
            @NotNull final Long idTarea, @NotNull final String cclIdOrigen) {
        return this.tareaPersonaHistoricoRepositoryCustom
            .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(idTarea, cclIdOrigen,
                    TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);
    }

}
