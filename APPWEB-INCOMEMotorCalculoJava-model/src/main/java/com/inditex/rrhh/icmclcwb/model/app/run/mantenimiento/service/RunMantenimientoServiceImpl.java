package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;

@Service
@Validated
public class RunMantenimientoServiceImpl implements RunMantenimientoService {

    @Autowired
    private RunMantenimientoLimpiezaService runMantenimientoLimpiezaService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunMantenimientoDto run() {
        return RunMantenimientoDto.builder().runMantenimientoLimpieza(runMantenimientoLimpiezaService.run()).build();
    }
    
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunMantenimientoDto runIdTarea(@NotNull Long id) {
        return RunMantenimientoDto.builder().runMantenimientoLimpieza(runMantenimientoLimpiezaService.runIdTarea(id)).build();
    }


}