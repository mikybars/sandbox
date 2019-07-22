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
    @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #idOrigen}")
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(idTarea,
                idOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_and_tipo_dato_in_ambito", key = "{#idTarea, #idOrigen, #idsTipoDato}")
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, idsTipoDato);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_tipo_dato_in_ambito", key = "{#idTarea, #idOrigen, #idsTipoDato}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
            @NotNull final Long idTarea, @NotBlank String idOrigen, @NotNull final List<Long> idsTipoDato) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, idOrigen, idsTipoDato);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #idOrigen}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(
            @NotNull final Long idTarea, @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom
                .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(idTarea, idOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen", key = "{#idTarea, #idOrigen}")
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepository.findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(idTarea, idOrigen);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen_and_tipo_dato", key = "{#idTarea, #idOrigen, #idVentaConcepto}")
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndIdOrigen(@NotNull Long idTarea, @NotNull String idOrigen,
            @NotNull Long idVentaConcepto) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, idOrigen, idVentaConcepto);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen", key = "{#idTarea, #idOrigen}")
    public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndIdOrigen(@NotNull Long idTarea, @NotNull String idOrigen) {
        return tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, idOrigen);
    }
}
