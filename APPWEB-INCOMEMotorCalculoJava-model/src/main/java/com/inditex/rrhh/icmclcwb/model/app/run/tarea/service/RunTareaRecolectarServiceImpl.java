package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;

@Service
@Validated
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

    @Autowired
    private RunTareaRecolectarAmbitoService runTareaRecolectarAmbitoService;

    @Autowired
    private RunTareaRecolectarCondicionesService runTareaRecolectarCondicionesService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaRecolectarService.run.timer", metricGroupName = "RunTareaRecolectarServiceGroup", metricDescription = "RunTareaRecolectarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRecolectarService.run.counter", metricGroupName = "RunTareaRecolectarServiceGroup", metricDescription = "RunTareaRecolectarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        runTareaRecolectarAmbitoService.run(runTarea);
        runTareaRecolectarCondicionesService.run(runTarea);
    }

}
