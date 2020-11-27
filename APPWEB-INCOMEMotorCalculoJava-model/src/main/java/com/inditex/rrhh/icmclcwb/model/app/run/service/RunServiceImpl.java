package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PreValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private RunTrabajoService runTrabajoService;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private RunTareaService runTareaService;

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaPrevalidacionService tareaPrevalidacionService;

    @Autowired
    private RunLimpiezaService runLimpiezaService;

    @Autowired
    private RunProgramacionService runProgramacionService;

    @Autowired
    private RunTareaPreValidarService runTareaPreValidarService;

    @Autowired
    @Qualifier("preValidarProperties")
    private PreValidarPropertiesDto preValidarProperties;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runTrabajo(@NotNull @Positive final Long id) {
        this.runTrabajoService.run(RunTrabajoDto.builder().trabajo(this.trabajoService.find(id)).build());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runTarea(@NotNull @Positive final Long id) {
        final TareaDto tarea = this.tareaService.find(id);
        this.runTareaService
            .run(RunTareaDto.builder().trabajo(this.trabajoService.find(tarea.getIdTrabajo())).tarea(tarea).build());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runLimpieza(@NotNull @Positive final Long id) {
        this.runLimpiezaService.run(RunLimpiezaDto.builder().tarea(this.tareaService.find(id)).build());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runProgramacion(@NotNull @Positive final Long id) {
        this.runProgramacionService.run(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void runTareaPreValidar(@NotNull @Positive final Long id) {
        final TareaDto tarea = this.tareaService.find(id);
        if (this.preValidarProperties.isEnabled()) {
            this.runTareaPreValidarService
                .run(RunTareaPrevalidarDto.builder()
                    .tareaPrevalidacionDto(this.tareaPrevalidacionService.create(tarea))
                    .tarea(tarea)
                    .build());
        } else {
            this.runTareaService
                .run(RunTareaDto.builder()
                    .trabajo(this.trabajoService.find(tarea.getIdTrabajo()))
                    .tarea(tarea)
                    .build());
        }
    }

}
