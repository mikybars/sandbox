package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

    @Override
    public RunTrabajoDto runTrabajo(@NotNull @Positive final Long id) {
        return runTrabajoService.run(RunTrabajoDto.builder().trabajo(trabajoService.find(id)).build());
    }

    @Override
    public RunTareaDto runTarea(@NotNull @Positive final Long id) {
        TareaDto tarea = tareaService.find(id);
        return runTareaService.run(RunTareaDto.builder().trabajo(trabajoService.find(tarea.getIdTrabajo())).tarea(tarea).build());
    }

}
