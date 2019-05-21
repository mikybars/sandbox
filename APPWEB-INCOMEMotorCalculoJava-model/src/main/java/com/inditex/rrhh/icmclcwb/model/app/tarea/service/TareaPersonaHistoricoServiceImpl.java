package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
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
    public List<TareaPersonaHistoricoDto> save(@Valid final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico,
            @Valid final TareaDto tarea) {
        List<TareaPersonaHistoricoDto> result = new ArrayList<>();
        List<TareaPersonaHistorico> data = tareaPersonaHistoricoMapper
                .mergeTareaPersonaHistoricoDtoAndTareaDtoToTareaPersonaHistorico(tareaEmpleadoHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(tareaPersonaHistoricoMapper.tareaPersonaHistoricoToTareaPersonaHistoricoDto(
                    tareaPersonaHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaPersonaHistoricoDto> saveGenericEmpleadoResultItemDto(
            @Valid final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaPersonaHistoricoMapper
                .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(genericEmpleadoResultItemDto), tarea);
    }

    @Override
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaPersonaHistoricoRepository.findIdPersonaByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaPersonaHistoricoRepository.findIdPersonaHistoricoByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

    @Override
    public List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen) {
        // TODO Agregar idOrigen
        return tareaPersonaHistoricoRepository.findIdPersonaLocalByIdTareaAndIdOrigen(idTarea/* , idOrigen */);
    }

}
