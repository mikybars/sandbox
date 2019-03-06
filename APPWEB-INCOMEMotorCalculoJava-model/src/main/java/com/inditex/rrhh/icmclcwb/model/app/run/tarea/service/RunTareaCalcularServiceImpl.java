package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.AlgoritmoFactory;

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
    private TareaEmpleadoEstadoService tareaEmpleadoEstadoService;

    @Autowired
    private AlgoritmoFactory algoritmoFactory;
    
    @Autowired
    private AlgoritmoService algoritmoService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        TareaDto tarea = tareaService.find(runTarea.getTarea().getId());
        if (EstadoTareaEnum.PENDIENTE_CALCULAR.getId().equals(tarea.getEstado().getId())) {
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_CALCULAR.getDto());
            runTarea.getRunTareaCalcular().getEmpleado().addAll(tareaEmpleadoEstadoService
                    .findIdsEmpleadoByIdTareaAndIdEstado(tarea.getId(), EstadoTareaEmpleadoEnum.PENDIENTE.getId()));
            List<Long> algoritmosIds = algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId());
            algoritmosIds.stream().forEach(item -> {
                AlgoritmoDto algoritmoDto = algoritmoService.findById(item);
                if (algoritmoDto != null) {
                    runTarea.getRunTareaCalcular().getAlgoritmoCalculoDto().add(algoritmoDto);
                } else {
                    log.warn(
                            "Tarea[{}] :: RunTareaCalcularService.run() :: No existe algoritmo para el tipo de calculo + tipo de comision",
                            tarea.getId());
                }
            });

            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(runTarea.getRunTareaCalcular().getAlgoritmoCalculoDto()).log().parallel()
                    .runOn(Schedulers.parallel()).doOnNext(algoritmo -> algoritmoFactory
                            .getAlgoritmo(algoritmo.getNombre()).execute(runTarea, algoritmo).onErrorResume(ex -> {
                                log.error(ex.getMessage(), ex);
                                return Flux.empty();
                            }).subscribe())
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new ReactorIcmclcwbException(e.getMessage(), e);
            }
            tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.PENDIENTE_CONSOLIDAR.getDto());
        }
        return runTarea;
    }

}
