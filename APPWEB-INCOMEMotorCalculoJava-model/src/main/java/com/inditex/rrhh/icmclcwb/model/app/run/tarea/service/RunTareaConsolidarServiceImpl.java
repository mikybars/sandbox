package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Service
@Validated
public class RunTareaConsolidarServiceImpl implements RunTareaConsolidarService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Autowired
    private RunTareaConsolidarByAmbitoService runTareaConsolidarByAmbitoService;

    @Autowired
    private RunTareaConsolidarByAmbitoLocalizacionService runTareaConsolidarByAmbitoLocalizacionService;

    @Autowired
    private RunTareaConsolidarByAmbitoPersonaService runTareaConsolidarByAmbitoPersonaService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaConsolidarService.run.timer", metricGroupName = "RunTareaConsolidarServiceGroup", metricDescription = "RunTareaConsolidarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaConsolidarService.run.counter", metricGroupName = "RunTareaConsolidarServiceGroup", metricDescription = "RunTareaConsolidarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        final TrabajoDto trabajo = runTarea.getTrabajo();
        tareaCalculoPersonaService.updateWithEstado(runTarea, EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
                EstadoTareaCalculoPersonaEnum.OK.getDto());
        if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaConsolidarByAmbitoService.run(runTarea);
        } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaConsolidarByAmbitoLocalizacionService.run(runTarea);
        } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaConsolidarByAmbitoPersonaService.run(runTarea);
        } else {
            throw new IcmclcwbException("El tipo ambito no esta soportado");
        }
        tareaService.updateEstadoFinal(runTarea.getTarea());
    }

}
