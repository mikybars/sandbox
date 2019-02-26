package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

@Service
@Validated
public class RunTrabajoServiceImpl implements RunTrabajoService {

    @Autowired
    private TareaService tareaService;

    @Auditoria
    @CounterMetric
    @TimerMetric 
    @Override
    public RunTrabajoDto run(@NotNull @Valid final RunTrabajoDto runTrabajo) {
        // TODO Periodo + validaciones + eventos + ...
        runTrabajo.setTarea(tareaService.create(runTrabajo.getTrabajo()));
        return runTrabajo;
    }

}