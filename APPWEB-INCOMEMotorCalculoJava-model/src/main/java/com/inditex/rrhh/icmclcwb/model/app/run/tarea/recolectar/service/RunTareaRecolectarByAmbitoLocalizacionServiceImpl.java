package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;

@Service
@Validated
public class RunTareaRecolectarByAmbitoLocalizacionServiceImpl
        implements RunTareaRecolectarByAmbitoLocalizacionService {

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        // TODO Fase 1 - Hito 4
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

}
