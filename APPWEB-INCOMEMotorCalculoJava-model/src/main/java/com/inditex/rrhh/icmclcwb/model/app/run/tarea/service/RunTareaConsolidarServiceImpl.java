package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTareaAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

@Service
@Validated
public class RunTareaConsolidarServiceImpl implements RunTareaConsolidarService {

    @Autowired
    private TareaService tareaService;

    @CounterMetric
    @TimerMetric
    @RunTareaAuditoria
    @Override
    public RunTareaDto run(@Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        if (EstadoTareaEnum.PENDIENTE_CONSOLIDACION.getId().equals(tarea.getEstado().getId())) {
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_CONSOLIDACION.getDto());
            TestUtils.threadSleep();
            tareaService.modifyEstadoTareaFinal(tarea, EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getDto());
        }
        return runTarea;
    }

}