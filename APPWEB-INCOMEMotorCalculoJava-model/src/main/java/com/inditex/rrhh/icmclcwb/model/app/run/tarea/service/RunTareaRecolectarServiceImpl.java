package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoPresupuestoService;
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

    @Autowired
    private RunTareaRecolectarAmbitoPresupuestoService runTareaRecolectarAmbitoPresupuestoService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaRecolectarService.run.timer",
            metricGroupName = "RunTareaRecolectarServiceGroup",
            metricDescription = "RunTareaRecolectarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRecolectarService.run.counter",
            metricGroupName = "RunTareaRecolectarServiceGroup",
            metricDescription = "RunTareaRecolectarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        // 1º Recuperamos el ámbito global como ya se está haciendo
        runTareaRecolectarAmbitoService.run(runTarea);
        // 2º Recuperamos las estructuras de comisión, hay que separar este bloque para solo tener los
        // servicios que afectan al ambito "runTareaRecolectarCondicionesAmbitoService"
        runTareaRecolectarAmbitoPresupuestoService.run(runTarea);
        // 3º Recalculamos el ámbito para las personas afectadas por las condiciones anteriores en otro
        // servicio "runTareaRecolectarAmbitoCondicionesService".
        // Hay que consultar a Meta4 al servicio nuevo que da la fecha mínima y máxima y con eso recuperar
        // el ámbito para esas personas en ese rango.
        // Hay que eliminar el ámbito de esas personas y recargarlo
        // 4º Recuperamos las condiciones como hasta ahora
        runTareaRecolectarCondicionesService.run(runTarea);
    }

}
