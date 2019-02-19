package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.concurrent.CountDownLatch;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTareaAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.AlgoritmoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.AlgoritmoFactory;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunTareaCalcularServiceImpl implements RunTareaCalcularService {

    @Autowired
    private Logger log;

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaEmpleadoEstructuraService tareaEmpleadoEstructuraService;

    @Autowired
    private TareaEmpleadoEstadoService tareaEmpleadoEstadoService;

    @Autowired
    private AlgoritmoFactory calculoAlgoritmoFactory;

    @CounterMetric
    @TimerMetric
    @RunTareaAuditoria
    @Override
    public RunTareaDto run(@Valid final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        if (EstadoTareaEnum.PENDIENTE_CALCULO.getId().equals(tarea.getEstado().getId())) {
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_CALCULO.getDto());
            runTarea.getRunTareaCalcular().getEmpleado()
                    .addAll(tareaEmpleadoEstadoService.findIdsEmpleadoByIdTareaAndIdEstado(tarea.getId(),
                            EstadoTareaEmpleadoEnum.PENDIENTE.getId()));
            runTarea.getRunTareaCalcular().getTipoCalculo()
                    .addAll(tareaEmpleadoEstructuraService.findIdTipoCalculoByIdTarea(tarea.getId()));
            runTarea.getRunTareaCalcular().getTipoCalculo().forEach(item -> {
                AlgoritmoEnum algoritmo = AlgoritmoEnum.of(item);
                if (algoritmo != null) {
                    runTarea.getRunTareaCalcular().getAlgoritmoCalculo().add(algoritmo);
                } else {
                    log.warn(
                            "Tarea[{}] :: RunTareaCalcularService.run() :: No existe algoritmo para el tipo de calculo: {}",
                            tarea.getId(), item);
                }
            });

            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(runTarea.getRunTareaCalcular().getAlgoritmoCalculo()).log().parallel()
                    .runOn(Schedulers.parallel()).doOnNext(algoritmo -> calculoAlgoritmoFactory
                            .getAlgoritmo(algoritmo.getType()).execute(runTarea).onErrorResume(ex -> {
                                log.error(ex.getMessage(), ex);
                                return Flux.empty();
                            }).subscribe())
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new ReactorIcmclcwbException(e.getMessage(), e);
            }

            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.PENDIENTE_CONSOLIDACION.getDto());
        }
        return runTarea;
    }

}
