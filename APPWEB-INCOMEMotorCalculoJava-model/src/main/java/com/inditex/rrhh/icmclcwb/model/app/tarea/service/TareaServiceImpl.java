package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;

@Service
@Validated
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private TareaRepositoryCustom tareaRepositoryCustom;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaAmbitoService tareaAmbitoService;

    @Autowired
    private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;

    @Autowired
    private TareaAmbitoPersonaService tareaAmbitoPersonaService;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Autowired
    private SenderTarea senderTarea;

    @Override
    public TareaDto save(@Valid @NotNull final TareaDto tarea) {
        return this.tareaMapper.tareaToTareaDto(this.tareaRepository.save(this.tareaMapper.tareaDtoToTarea(tarea)));
    }

    @Override
    public TareaDto find(@NotNull @Positive final Long id) {
        final TareaDto tarea = this.tareaMapper.tareaToTareaDto(this.tareaRepository.findById(id).get());
        tarea.setAmbito(this.tareaAmbitoService.findByTarea(tarea));
        tarea.setLocalizacion(this.tareaAmbitoLocalizacionService.findByTarea(tarea));
        tarea.setPersona(this.tareaAmbitoPersonaService.findByTarea(tarea));
        return tarea;
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public TareaDto create(@Valid @NotNull final TareaDto tarea) {
        tarea.setFechaHoraCreacion(LocalDateTime.now());
        tarea.setEstado(EstadoTareaEnum.PENDIENTE.getDto());
        final TareaDto result = this.save(tarea);
        if (CollectionUtils.isNotEmpty(tarea.getAmbito())) {
            result.setAmbito(this.tareaAmbitoService.create(tarea.getAmbito(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
            result.setLocalizacion(this.tareaAmbitoLocalizacionService.create(tarea.getLocalizacion(), result));
        }
        if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
            result.setPersona(this.tareaAmbitoPersonaService.create(tarea.getPersona(), result));
        }
        this.tareaFaseService.create(result);
        this.senderTarea.send(result);
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public List<TareaDto> create(@Valid @NotNull final TrabajoDto trabajo) {
        final List<TareaDto> result = new ArrayList<>();
        this.tareaMapper.mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTareaDto(trabajo.getEmpresa(), trabajo)
            .forEach(item -> result.add(this.create(item)));
        return result;
    }

    @Override
    public List<TareaDto> findByTrabajoId(@NotNull @Positive final Long id) {
        return this.tareaMapper.tareaToTareaDto(this.tareaRepository.findByTrabajoId(id));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFin(@Valid @NotNull final TareaDto tarea) {
        this.tareaRepositoryCustom.updateFechaFin(tarea);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaInicioAndEstado(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final EstadoTareaDto estado) {
        this.tareaRepositoryCustom.updateFechaInicioAndEstado(tarea, estado);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void updateEstado(@Valid @NotNull final TareaDto tarea, @Valid @NotNull final EstadoTareaDto estado) {
        this.tareaRepositoryCustom.updateEstado(tarea, estado);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateEstadoFinal(@Valid @NotNull final TareaDto tarea) {
        this.tareaRepositoryCustom.updateEstadoFinal(tarea);
    }

    @Override
    public List<IdTareaDto> findLimpieza() {
        return this.tareaRepositoryCustom.findLimpieza();
    }

    @Override
    public List<IdTareaDto> findLimpiezaByIdTarea(@NotNull @Positive final Long idTarea) {
        return this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea);
    }

}
