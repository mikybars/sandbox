package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoGrupoEnum;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoGrupoDato;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionHistoricoServiceImpl implements TareaLocalizacionHistoricoService {

    @Autowired
    private TareaLocalizacionHistoricoRepository tareaLocalizacionHistoricoRepository;

    @Autowired
    private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;

    @Autowired
    private TareaLocalizacionHistoricoMapper tareaLocalizacionHistoricoMapper;

    @Override
    public List<TareaLocalizacionHistoricoDto> save(@Valid final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionHistoricoDto> result = new ArrayList<>();
        List<TareaLocalizacionHistorico> data = tareaLocalizacionHistoricoMapper
                .mergeTareaLocalizacionHistoricoDtoAndTareaDtoToTareaLocalizacionHistorico(tareaLocalizacionHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(tareaLocalizacionHistoricoMapper
                    .tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(tareaLocalizacionHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionHistoricoDto> saveGenericTiendaResultItemDto(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaLocalizacionHistoricoMapper
                .genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(genericTiendaResultItemDto), tarea);
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(idTarea, idOrigen);
    }
    
    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, idsTipoDato);
    }
    
    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, idsTipoDato);
    }
    
    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #idOrigin}")
    @Retryable(maxAttemptsExpression = "#{${app.envars.ptr.config.max-attempts}}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(idTarea, idOrigen);
    }
    
    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepository.findIdLocalizacionDtoByIdTareaAndIdOrigen(idTarea, idOrigen);
    }


    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepository.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(idTarea, idOrigen);
    }

    @Override
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndIdOrigen(@NotNull Long idTarea, @NotNull String idOrigen,
            @NotNull List<Long> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, idOrigen, idsTipoDato);
    }

    @Override
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndIdOrigen(@NotNull Long idTarea, @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, idOrigen);
    }
}
