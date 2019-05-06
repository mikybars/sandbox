package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Service
@Validated
public class RunTareaRecolectarAmbitoServiceImpl implements RunTareaRecolectarAmbitoService {

    @Autowired
    private RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

    @Autowired
    private RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

    @Autowired
    private RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        final TrabajoDto trabajo = runTarea.getTrabajo();
        if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaRecolectarByAmbitoService.run(runTarea);
        } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
        } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
            runTareaRecolectarByAmbitoPersonaService.run(runTarea);
        } else {
            throw new IcmclcwbException("El tipo ambito no esta soportado");
        }
    }

}
