package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PreValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarOfflineService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarOnlineService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaPrevalidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaPreValidarServiceImpl implements RunTareaPreValidarService {

    @Autowired
    private TareaPrevalidacionService tareaPrevalidacionService;

    @Autowired
    private RunTareaPreValidarOfflineService runTareaPreValidarOfflineService;

    @Autowired
    private RunTareaPreValidarOnlineService runTareaPreValidarOnlineService;

    @Autowired
    @Qualifier("preValidarProperties")
    private PreValidarPropertiesDto preValidarProperties;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaPreValidarServiceImpl.run.timer",
            metricGroupName = "RunTareaPreValidarGroup",
            metricDescription = "RunTareaPreValidarServiceImpl.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaPreValidarServiceImpl.run.counter",
            metricGroupName = "RunTareaPreValidarGroup",
            metricDescription = "RunTareaPreValidarServiceImpl.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            this.runTareaPreValidarOnlineService.run(runTareaPrevalidarDto);
            this.runTareaPreValidarOfflineService.run(runTareaPrevalidarDto);
            // Gestion envio/reenvio
            this.tareaPrevalidacionService.send(runTareaPrevalidarDto.getTareaPrevalidacionDto());
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            this.tareaPrevalidacionService.updateEstado(runTareaPrevalidarDto.getTareaPrevalidacionDto(),
                    EstadoTareaPrevalidacionEnum.ERROR.getDto());
            throw e;
        } finally {
            this.tareaPrevalidacionService.updateFechaFin(runTareaPrevalidarDto.getTareaPrevalidacionDto());
        }
    }

}
