package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
    private RunLimpiezaService runLimpiezaService;

    @Autowired
    private RunProgramacionService runProgramacionService;

    @Override
    public void runTrabajo(@NotNull @Positive final Long id) {
        this.runTrabajoService.run(RunTrabajoDto.builder().trabajo(this.trabajoService.find(id)).build());
    }

    @Override
    public void runTarea(@NotNull @Positive final Long id) {
        final TareaDto tarea = this.tareaService.find(id);
        this.runTareaService
            .run(RunTareaDto.builder().trabajo(this.trabajoService.find(tarea.getIdTrabajo())).tarea(tarea).build());
    }

    @Override
    public void runLimpieza(@NotNull @Positive final Long id) {
        this.runLimpiezaService
            .run(RunLimpiezaDto.builder().id(id).tarea(this.tareaService.findByIdLimpieza(id)).build());
    }

    @Override
    public void runProgramacion(@NotNull @Positive final Long id) {
        this.runProgramacionService.run(id);
    }

}
