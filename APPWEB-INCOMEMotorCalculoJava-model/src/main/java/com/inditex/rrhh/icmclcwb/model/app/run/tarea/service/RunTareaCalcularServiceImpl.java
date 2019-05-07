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
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.ReactorUtils;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunTareaCalcularServiceImpl implements RunTareaCalcularService {

    @Autowired
    private Logger log;

    @Autowired
    private RunAlgoritmoFactory runAlgoritmoFactory;

    @Autowired
    private AlgoritmoService algoritmoService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();

//        List<Long> idAlgoritmos = algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId());
//        Flux.fromIterable(idAlgoritmos).parallel().runOn(Schedulers.parallel()).map(algoritmoService::findById)
//                .doOnNext(algoritmo -> {
//                    log.info("Inicio :: Lanzando algoritmo: {}", algoritmo);
//                    RunAlgoritmo runAlgoritmo = algoritmoFactory.getRunAlgoritmo(algoritmo.getNombre());
//                    runAlgoritmo.execute(runTarea, algoritmo);
//                    log.info("Fin :: Lanzando algoritmo: {}", algoritmo);
//                }).sequential().collectList().subscribeOn(Schedulers.parallel());

//        CountDownLatch latch = new CountDownLatch(1);
//        Flux.fromIterable(algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId()).stream()
//                .map(item -> algoritmoService.findById(item)).collect(Collectors.toList())).log().parallel()
//                .runOn(Schedulers.parallel()).doOnNext(algoritmo -> {
//                    log.info("Inicio :: Lanzando algoritmo: {}", algoritmo);
//                    runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre()).execute(runTarea, algoritmo);
//                    log.info("Fin :: Lanzando algoritmo: {}", algoritmo);
//                }).doOnError(ex -> log.error("doOnError: " + ex.getMessage(), ex)).sequential().collectList()
//                .doAfterTerminate(() -> ReactorUtils.countDown(latch)).subscribe();
//        ReactorUtils.await(latch);

        CountDownLatch latch = new CountDownLatch(1);
        Flux.fromIterable(algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId()).stream()
                .map(item -> algoritmoService.findById(item)).collect(Collectors.toList())).log().parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(algoritmo -> runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre()).execute(runTarea,
                        algoritmo))
                .doOnError(ex -> log.error("doOnError: " + ex.getMessage(), ex))
                .doAfterTerminate(() -> ReactorUtils.countDown(latch)).subscribe();
        ReactorUtils.await(latch);

//        CountDownLatch latch = new CountDownLatch(1);
//        Flux.fromIterable(algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId()).stream()
//                .map(item -> algoritmoService.findById(item)).collect(Collectors.toList())).log().parallel()
//                .runOn(Schedulers.parallel()).doOnNext(algoritmo -> algoritmoFactory.getAlgoritmo(algoritmo.getNombre())
//                        .execute(runTarea, algoritmo).onErrorResume(ex -> {
//                            log.error("onErrorResume: " + ex.getMessage(), ex);
//                            return Flux.empty();
//                        }).subscribe())
//                .doOnError(ex -> log.error("doOnError: " + ex.getMessage(), ex)).doAfterTerminate(latch::countDown)
//                .subscribe();
//        ReactorUtils.await(latch);

    }

}
