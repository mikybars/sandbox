package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

@Service
@Validated
public class RunTareaServiceImpl implements RunTareaService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private RunTareaRecolectarService runTareaRecolectarService;

    @Autowired
    private RunTareaProcesarService runTareaProcesarService;

    @Autowired
    private RunTareaCalcularService runTareaCalcularService;

    @Autowired
    private RunTareaConsolidarService runTareaConsolidarService;

    @Autowired
    private RunTareaRecolectarValidarService runTareaRecolectarValidarService;
    
    @Autowired
    private RunTareaRegularizarService runTareaPostProcesarService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        try {
            tareaService.updateFechaInicioAndEstado(runTarea.getTarea(), EstadoTareaEnum.EN_CURSO.getDto());
            runTareaRecolectarService.run(runTarea);
            runTareaRecolectarValidarService.run(runTarea);
            runTareaProcesarService.run(runTarea);
            runTareaCalcularService.run(runTarea);
            runTareaPostProcesarService.run(runTarea);
            runTareaConsolidarService.run(runTarea);
        } catch (Exception e) {
            tareaService.updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR.getDto());
            throw e;
        } finally {
            tareaService.updateFechaFin(runTarea.getTarea());
        }
    }

}
