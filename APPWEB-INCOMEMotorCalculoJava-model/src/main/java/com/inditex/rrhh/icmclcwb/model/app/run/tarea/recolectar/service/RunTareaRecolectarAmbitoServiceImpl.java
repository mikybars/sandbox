package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

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
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        final TareaDto tarea = runTarea.getTarea();
        if (CollectionUtils.isNotEmpty(tarea.getLocalizacion()) && CollectionUtils.isNotEmpty(tarea.getPersona())) {
            throw new IcmclcwbException("No es posible ejecutar por localizacion y persona");
        }else if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
            runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
        } else if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
            runTareaRecolectarByAmbitoPersonaService.run(runTarea);
        } else {
            runTareaRecolectarByAmbitoService.run(runTarea);
        }
        
        return runTarea;
    }
}
