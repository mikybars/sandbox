package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
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
    public List<TareaPersonaHistoricoDto> save(@Valid final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico) {
        return tareaPersonaHistoricoMapper
                .tareaPersonaHistoricoToTareaPersonaHistoricoDto(
                        tareaPersonaHistoricoRepositoryCustom.save(tareaPersonaHistoricoMapper.tareaPersonaHistoricoDtoToTareaPersonaHistorico(tareaEmpleadoHistorico)));
    }

    @Override
    public List<TareaPersonaHistoricoDto> merge(
            @Valid final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        return tareaPersonaHistoricoMapper
                .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(genericEmpleadoResultItemDto, tarea);
    }

    //TODO: No se está usando
    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return tareaPersonaHistoricoRepositoryCustom.findIdPersonaByIdTareaAndIdOrigenInAmbito(idTarea, cclIdOrigen);
    }
    
    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea, cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen_and_tipo_dato", key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato) {
        return tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
    }

    //TODO: No se está usando
    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return tareaPersonaHistoricoRepository.findIdPersonaHistoricoByIdTareaAndIdOrigen(idTarea, cclIdOrigen);
    }

    //TODO: No se está usando
    @Override
    public List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen) {
        return tareaPersonaHistoricoRepository.findIdPersonaLocalByIdTareaAndIdOrigen(idTarea, cclIdOrigen);
    }
}
