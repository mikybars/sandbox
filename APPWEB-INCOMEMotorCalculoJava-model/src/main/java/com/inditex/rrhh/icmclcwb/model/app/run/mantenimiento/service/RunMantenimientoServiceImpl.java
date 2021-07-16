package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;

@Service
@Validated
public class RunMantenimientoServiceImpl implements RunMantenimientoService {

    @Autowired
    private RunMantenimientoLimpiezaService runMantenimientoLimpiezaService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunMantenimientoService.run.timer",
            metricGroupName = "RunMantenimientoServiceGroup", metricDescription = "RunMantenimientoService.run.timer")
    @CounterFunctionalMetric(metricName = "RunMantenimientoService.run.counter",
            metricGroupName = "RunMantenimientoServiceGroup", metricDescription = "RunMantenimientoService.run.counter")
    @Override
    public RunMantenimientoDto run() {
        return RunMantenimientoDto.builder()
            .runMantenimientoLimpieza(this.runMantenimientoLimpiezaService.run())
            .build();
    }

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunMantenimientoService.runIdTarea.timer",
            metricGroupName = "RunMantenimientoServiceGroup",
            metricDescription = "RunMantenimientoService.runIdTarea.timer")
    @CounterFunctionalMetric(metricName = "RunMantenimientoService.runIdTarea.counter",
            metricGroupName = "RunMantenimientoServiceGroup",
            metricDescription = "RunMantenimientoService.runIdTarea.counter")
    @Override
    public RunMantenimientoDto runIdTarea(@NotNull final Long id) {
        return RunMantenimientoDto.builder()
            .runMantenimientoLimpieza(this.runMantenimientoLimpiezaService.runIdTarea(id))
            .build();
    }

}
