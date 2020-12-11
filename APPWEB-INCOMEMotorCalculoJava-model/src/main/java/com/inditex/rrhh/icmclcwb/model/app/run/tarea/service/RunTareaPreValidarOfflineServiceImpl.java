package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarOfflineService;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaPreValidarOfflineServiceImpl implements RunTareaPreValidarOfflineService {

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaPreValidarOfflineService.run.timer",
            metricGroupName = "RunTareaPreValidarOfflineServiceGroup",
            metricDescription = "RunTareaPreValidarOfflineService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaPreValidarOfflineService.run.counter",
            metricGroupName = "RunTareaPreValidarOfflineServiceGroup",
            metricDescription = "RunTareaPreValidarOfflineService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto) {
        try {
        } catch (final Exception e) {
            throw e;
        }
    }

}
