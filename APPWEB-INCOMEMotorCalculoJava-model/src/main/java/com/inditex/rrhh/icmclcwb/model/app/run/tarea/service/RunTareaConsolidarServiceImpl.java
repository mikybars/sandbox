package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Service
@Validated
public class RunTareaConsolidarServiceImpl implements RunTareaConsolidarService {

    @Autowired
    private RunTareaConsolidarByAmbitoService runTareaConsolidarByAmbitoService;

    @Autowired
    private RunTareaConsolidarByAmbitoLocalizacionService runTareaConsolidarByAmbitoLocalizacionService;

    @Autowired
    private RunTareaConsolidarByAmbitoPersonaService runTareaConsolidarByAmbitoPersonaService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        final TrabajoDto trabajo = runTarea.getTrabajo();
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
    }

}
