package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.EstadoTarea;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private TareaAmbitoService tareaAmbitoService;

    @Autowired
    private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;

    @Autowired
    private TareaAmbitoPersonaService tareaAmbitoPersonaService;

    @Autowired
    private SenderTarea senderTarea;

    @Transactional
    @Override
    public TareaDto save(@Valid final TareaDto tarea) {
        return tareaMapper.tareaToTareaDto(tareaRepository.save(tareaMapper.tareaDtoToTarea(tarea)));
    }

    @Override
    public TareaDto find(@NotNull @Positive final Long id) {
        TareaDto tarea = tareaMapper.tareaToTareaDto(tareaRepository.findById(id).get());
        tarea.setAmbito(tareaAmbitoService.findByTarea(tarea));
        tarea.setLocalizacion(tareaAmbitoLocalizacionService.findByTarea(tarea));
        tarea.setPersona(tareaAmbitoPersonaService.findByTarea(tarea));
        return tarea;
    }

    @Transactional
    @Override
    public TareaDto create(@Valid final TareaDto tarea) {
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setEstado(EstadoTareaEnum.PENDIENTE_RECOLECTAR.getDto());
        TareaDto result = save(tarea);
        if (CollectionUtils.isNotEmpty(tarea.getAmbito())) {
            result.setAmbito(tareaAmbitoService.create(tarea.getAmbito(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
            result.setLocalizacion(tareaAmbitoLocalizacionService.create(tarea.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
            result.setPersona(tareaAmbitoPersonaService.create(tarea.getPersona(), result));
        }
        senderTarea.send(result);
        return null;
    }

    @Transactional
    @Override
    public List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo) {
        List<TareaDto> result = new ArrayList<>();
        tareaMapper.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(trabajo.getEmpresa(), trabajo)
                .forEach(item -> result.add(create(item)));
        return result;
    }

    @Transactional
    @Override
    public int modifyEstadoTarea(@Valid final TareaDto tarea, @Valid final EstadoTareaDto estado) {
        return tareaRepository.setEstado(tarea.getId(), EstadoTarea.builder().id(estado.getId()).build());
    }

    @Transactional
    @Override
    public int modifyFechaInicioTarea(@Valid final TareaDto tarea) {
        return tareaRepository.setFechaInicioTarea(tarea.getId(), new Date());
    }

    @Transactional
    @Override
    public int modifyFechaFinTarea(@Valid final TareaDto tarea) {
        return tareaRepository.setFechaFinTarea(tarea.getId(), new Date());
    }

}