package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private RunTareaService tareaRunService;

    @Autowired
    private TareaService tareaService;

    @Override
    public RunTareaDto runTarea(@NotNull @Positive final Long id) {
        return tareaRunService.run(RunTareaDto.builder().tarea(tareaService.findTarea(id)).build());
    }

}
