package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.AlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.ReactorUtils;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunTareaCalcularServiceImpl implements RunTareaCalcularService {

    @Autowired
    private Logger log;

    @Autowired
    private AlgoritmoFactory algoritmoFactory;

    @Autowired
    private AlgoritmoService algoritmoService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        CountDownLatch latch = new CountDownLatch(1);
        Flux.fromIterable(algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId()).stream()
                .map(item -> algoritmoService.findById(item)).collect(Collectors.toList())).log().parallel()
                .runOn(Schedulers.parallel()).doOnNext(algoritmo -> algoritmoFactory.getAlgoritmo(algoritmo.getNombre())
                        .execute(runTarea, algoritmo).onErrorResume(ex -> {
                            log.error("onErrorResume: " + ex.getMessage(), ex);
                            return Flux.empty();
                        }).subscribe())
                .doOnError(ex -> log.error("doOnError: " + ex.getMessage(), ex)).doAfterTerminate(latch::countDown)
                .subscribe();
        ReactorUtils.await(latch);
    }

}
