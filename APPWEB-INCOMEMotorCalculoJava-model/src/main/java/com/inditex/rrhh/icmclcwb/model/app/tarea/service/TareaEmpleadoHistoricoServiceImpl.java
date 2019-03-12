package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoHistoricoRepositoryCustom;

@Service
@Validated
public class TareaEmpleadoHistoricoServiceImpl implements TareaEmpleadoHistoricoService {

    @Autowired
    private TareaEmpleadoHistoricoRepository tareaEmpleadoHistoricoRepository;

    @Autowired
    private TareaEmpleadoHistoricoRepositoryCustom tareaEmpleadoHistoricoRepositoryCustom;

    @Autowired
    private TareaEmpleadoHistoricoMapper tareaEmpleadoHistoricoMapper;

    @Override
    public List<TareaEmpleadoHistoricoDto> save(@Valid final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico,
            @Valid final TareaDto tarea) {
        List<TareaEmpleadoHistoricoDto> result = new ArrayList<>();
        List<TareaEmpleadoHistorico> data = tareaEmpleadoHistoricoMapper
                .mergeTareaEmpleadoHistoricoDtoAndTareaDtoToTareaEmpleadoHistorico(tareaEmpleadoHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(tareaEmpleadoHistoricoMapper.tareaEmpleadoHistoricoToTareaEmpleadoHistoricoDto(
                    tareaEmpleadoHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaEmpleadoHistoricoDto> saveGenericEmpleadoResultItemDto(
            final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaEmpleadoHistoricoMapper
                .genericEmpleadoResultItemDtoToTareaEmpleadoHistoricoDto(genericEmpleadoResultItemDto), tarea);
    }

    @Override
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaEmpleadoHistoricoRepository.findIdPersonaByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaEmpleadoHistoricoRepository.findIdPersonaHistoricoByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

    @Override
    public List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaEmpleadoHistoricoRepository.findIdPersonaLocalByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

}
