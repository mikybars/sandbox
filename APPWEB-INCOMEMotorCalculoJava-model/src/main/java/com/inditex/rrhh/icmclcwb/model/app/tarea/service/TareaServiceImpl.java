package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Service
@Validated
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private TareaMapper tareaMapper;
//
//    @Autowired
//    private TareaAmbitoOrigenService tareaAmbitoOrigenService;
//
//    @Autowired
//    private TareaAmbitoEmpresaService tareaAmbitoEmpresaService;
//
//    @Autowired
//    private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;
//
//    @Autowired
//    private TareaAmbitoPersonaService tareaAmbitoPersonaService;

    @Override
    public TareaDto find(@NotNull @Positive final Long id) {
        return null;
    }

    @Override
    public TareaDto create(@Valid final TareaDto tarea) {
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setEstado(EstadoTareaEnum.PENDIENTE_DATOS.getDto());
        TareaDto result = tareaMapper
                .tareaToTareaDto(tareaRepository.save(tareaMapper.tareaDtoToTarea(tarea)));
        if (CollectionUtils.isNotEmpty(tarea.getAmbito())) {
            //result.setOrigen(tareaAmbitoService.create(tarea.getOrigen(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
            //result.setLocalizacion(tareaAmbitoLocalizacionService.create(tarea.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
            //result.setEmpresa(tareaAmbitoPersonaService.create(tarea.getPersona(), result));
        }
        return null;
    }

    @Override
    public List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo) {
        List<TareaDto> result = new ArrayList<>();
        tareaMapper.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(trabajo.getEmpresa(), trabajo)
                .forEach(item -> result.add(create(item)));
        return result;
    }

}