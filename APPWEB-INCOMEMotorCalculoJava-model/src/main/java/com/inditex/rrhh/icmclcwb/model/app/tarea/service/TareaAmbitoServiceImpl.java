package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoRepository;

@Service
@Validated
public class TareaAmbitoServiceImpl implements TareaAmbitoService {

    @Autowired
    private TareaAmbitoRepository tareaAmbitoRepository;

    @Autowired
    private TareaAmbitoMapper tareaAmbitoMapper;

    @Override
    public List<TareaAmbitoDto> create(@Valid @NotNull @NotEmpty final List<TareaAmbitoDto> tareaAmbito,
            @Valid @NotNull final TareaDto tarea) {
        return tareaAmbitoMapper.tareaAmbitoToTareaAmbitoDto(tareaAmbitoRepository
                .saveAll(tareaAmbitoMapper.mergeTareaAmbitoDtoAndTareaDtoToTareaAmbito(tareaAmbito, tarea)));
    }

    @Override
    public List<TareaAmbitoDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
        return tareaAmbitoMapper.tareaAmbitoToTareaAmbitoDto(tareaAmbitoRepository.findByTareaId(tarea.getId()));
    }

}
