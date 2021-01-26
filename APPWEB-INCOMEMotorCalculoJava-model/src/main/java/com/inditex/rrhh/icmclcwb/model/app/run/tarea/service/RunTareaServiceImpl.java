package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaServiceImpl implements RunTareaService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

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
    private RunTareaRegularizarService runTareaRegularizarService;

    @Autowired
    private RunTareaRegularizarChallengeService runTareaRegularizarChallengeService;

    @Autowired
    private RunTareaAjustarService runTareaAjustarService;

    @Autowired
    private ComisService comisService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaService.run.timer", metricGroupName = "RunTareaServiceGroup",
            metricDescription = "RunTareaService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaService.run.counter", metricGroupName = "RunTareaServiceGroup",
            metricDescription = "RunTareaService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        try {
            this.comisService.findPresenciasOrigenAndFecha(runTarea, runTarea.getTarea().getAmbito().get(0));
            this.tareaService.updateFechaInicioAndEstado(runTarea.getTarea(), EstadoTareaEnum.EN_CURSO.getDto());
            this.runTareaRecolectarService.run(runTarea);
            this.runTareaRecolectarValidarService.run(runTarea);
            this.runTareaProcesarService.run(runTarea);
            this.runTareaCalcularService.run(runTarea);
            this.runTareaRegularizarChallengeService.run(runTarea);
            this.runTareaRegularizarService.run(runTarea);
            this.runTareaAjustarService.run(runTarea);
            this.tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
                    EstadoTareaCalculoPersonaEnum.OK.getDto());
            this.runTareaConsolidarService.run(runTarea);
            this.tareaService.updateEstadoFinal(runTarea.getTarea());
        } catch (final Exception e) {
            this.tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
                    EstadoTareaCalculoPersonaEnum.KO.getDto());
            this.runTareaConsolidarService.run(runTarea);
            this.tareaService.updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR.getDto());
            throw e;
        } finally {
            this.tareaService.updateFechaFin(runTarea.getTarea());
        }
    }

}
