package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;

@Service
@Validated
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

    @Autowired
    private TareaService tareaService;

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
        if (EstadoTareaEnum.PENDIENTE_RECOLECTAR.getId().equals(tarea.getEstado().getId())) {
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_RECOLECTAR.getDto());
            // TODO PoC
            runTareaRecolectarByAmbitoService.runPoC(runTarea);
//            if (CollectionUtils.isNotEmpty(tarea.getLocalizacion()) && CollectionUtils.isNotEmpty(tarea.getPersona())) {
//                throw new IcmclcwbException("No es posible ejecutar por localizacion y persona");
//            }else if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
//                runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
//            } else if (CollectionUtils.isNotEmpty(tarea.getPersona())) {
//                runTareaRecolectarByAmbitoPersonaService.run(runTarea);
//            } else {
//                runTareaRecolectarByAmbitoService.run(runTarea);
//            }
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.PENDIENTE_CALCULAR.getDto());
        }
        return runTarea;
    }

}
