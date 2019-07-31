package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
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
    public List<TareaLocalizacionHistoricoDto> save(
            @Valid final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico) {
        return tareaLocalizacionHistoricoMapper.tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(
                    tareaLocalizacionHistoricoRepositoryCustom.save(tareaLocalizacionHistoricoMapper.tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(tareaLocalizacionHistorico)));
    }

    @Override
    public List<TareaLocalizacionHistoricoDto> merge(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea) {
        return tareaLocalizacionHistoricoMapper
                .genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(genericTiendaResultItemDto, tarea);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #cclIdOrigen}")
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull String cclIdOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(idTarea,
                cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_and_tipo_dato_in_ambito", key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank String cclIdOrigen, @NotNull final List<Integer> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_tipo_dato_in_ambito", key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank String cclIdOrigen, @NotNull final List<Integer> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #cclIdOrigen}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
            @NotNull final Long idTarea, @NotNull String cclIdOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
            @NotNull String cclIdOrigen) {
        return tareaLocalizacionHistoricoRepository.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen_and_tipo_dato", key = "{#idTarea, #cclIdOrigen, #idVentaConcepto}")
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull Long idTarea, @NotNull String cclIdOrigen,
            @NotNull Long idVentaConcepto) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, cclIdOrigen, idVentaConcepto);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull Long idTarea, @NotNull String cclIdOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, cclIdOrigen);
    }
}
