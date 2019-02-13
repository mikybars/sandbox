package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import java.util.concurrent.CountDownLatch;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.AlgoritmoEnum;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.AlgoritmoFactory;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunTrabajoCalcularServiceImpl implements RunTrabajoCalcularService {

    @Autowired
    private Logger log;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoEmpleadoEstructuraService trabajoEmpleadoEstructuraService;

    @Autowired
    private TrabajoEmpleadoEstadoService trabajoEmpleadoEstadoService;

    @Autowired
    private AlgoritmoFactory calculoAlgoritmoFactory;

    @CounterMetric
    @TimerMetric
    @RunTrabajoAuditoria
    @Override
    public RunTrabajoDto run(@Valid final RunTrabajoDto runTrabajo) {
        TrabajoDto trabajo = runTrabajo.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto());
            runTrabajo.getRunTrabajoCalcular().getEmpleado()
                    .addAll(trabajoEmpleadoEstadoService.findIdsEmpleadoByIdTrabajoAndIdEstado(trabajo.getId(),
                            EstadoTrabajoEmpleadoEnum.PENDIENTE.getId()));
            runTrabajo.getRunTrabajoCalcular().getTipoCalculo()
                    .addAll(trabajoEmpleadoEstructuraService.findIdTipoCalculoByIdTrabajo(trabajo.getId()));
            runTrabajo.getRunTrabajoCalcular().getTipoCalculo().forEach(item -> {
                AlgoritmoEnum algoritmo = AlgoritmoEnum.of(item);
                if (algoritmo != null) {
                    runTrabajo.getRunTrabajoCalcular().getAlgoritmoCalculo().add(algoritmo);
                } else {
                    log.warn(
                            "Trabajo[{}] :: RunTrabajoCalcularService.run() :: No existe algoritmo para el tipo de calculo: {}",
                            trabajo.getId(), item);
                }
            });

            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(runTrabajo.getRunTrabajoCalcular().getAlgoritmoCalculo()).log().parallel()
                    .runOn(Schedulers.parallel()).doOnNext(algoritmo -> calculoAlgoritmoFactory
                            .getAlgoritmo(algoritmo.getType()).execute(runTrabajo).onErrorResume(ex -> {
                                log.error(ex.getMessage(), ex);
                                return Flux.empty();
                            }).subscribe())
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new ReactorIcmclcwbException(e.getMessage(), e);
            }

            trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto());
        }
        return runTrabajo;
    }

}
