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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.async.service.RunTareaPreValidarPresenciasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPreValidarOnlineService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoEstadoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaPreValidarOnlineServiceImpl implements RunTareaPreValidarOnlineService {

    @Autowired
    @Qualifier("preValidarProperties")
    private PreValidarPropertiesDto preValidarProperties;

    @Autowired
    private TareaPrevalidacionValidacionService tareaPrevalidacionValidacionService;

    @Autowired
    private RunTareaPreValidarPresenciasAsyncService runTareaPreValidarPresenciasAsyncService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaPreValidarOnlineService.run.timer",
            metricGroupName = "RunTareaPreValidarOnlineServiceGroup",
            metricDescription = "RunTareaPreValidarOnlineService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaPreValidarOnlineService.run.counter",
            metricGroupName = "RunTareaPreValidarOnlineServiceGroup",
            metricDescription = "RunTareaPreValidarOnlineService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            if (this.preValidarProperties.getOnline().isEnabled()) {
                this.tareaPrevalidacionValidacionService.create(runTareaPrevalidarDto.getTarea(),
                        TipoEstadoValidacionEnum.ONLINE.getId(), runTareaPrevalidarDto.getTareaPrevalidacionDto());

                final CompletableFuture<Void> cfPresencia = this.runTareaPreValidarPresenciasAsyncService
                    .run(runTareaPrevalidarDto);
                AsyncUtils.exceptionally(cfPresencia, cf, cfWait);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/
            }
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
