package com.inditex.rrhh.icmclcwb.model.app.run.proceso.service;

import java.util.concurrent.CountDownLatch;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunProcesoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.AlgoritmoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.AlgoritmoFactory;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunProcesoCalcularServiceImpl implements RunProcesoCalcularService {

    @Autowired
    private Logger log;

    @Autowired
    private ProcesoService procesoService;

    @Autowired
    private ProcesoEmpleadoEstructuraService procesoEmpleadoEstructuraService;

    @Autowired
    private ProcesoEmpleadoEstadoService procesoEmpleadoEstadoService;

    @Autowired
    private AlgoritmoFactory calculoAlgoritmoFactory;

    @CounterMetric
    @TimerMetric
    @RunProcesoAuditoria
    @Override
    public RunProcesoDto run(@Valid final RunProcesoDto runProceso) {
        ProcesoDto proceso = runProceso.getProceso();
        if (EstadoProcesoEnum.PENDIENTE_CALCULO.getId().equals(proceso.getEstado().getId())) {
            procesoService.modifyEstadoProceso(proceso, EstadoProcesoEnum.EN_CURSO_CALCULO.getDto());
            runProceso.getRunProcesoCalcular().getEmpleado()
                    .addAll(procesoEmpleadoEstadoService.findIdsEmpleadoByIdProcesoAndIdEstado(proceso.getId(),
                            EstadoProcesoEmpleadoEnum.PENDIENTE.getId()));
            runProceso.getRunProcesoCalcular().getTipoCalculo()
                    .addAll(procesoEmpleadoEstructuraService.findIdTipoCalculoByIdProceso(proceso.getId()));
            runProceso.getRunProcesoCalcular().getTipoCalculo().forEach(item -> {
                AlgoritmoEnum algoritmo = AlgoritmoEnum.of(item);
                if (algoritmo != null) {
                    runProceso.getRunProcesoCalcular().getAlgoritmoCalculo().add(algoritmo);
                } else {
                    log.warn(
                            "Proceso[{}] :: RunProcesoCalcularService.run() :: No existe algoritmo para el tipo de calculo: {}",
                            proceso.getId(), item);
                }
            });

            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(runProceso.getRunProcesoCalcular().getAlgoritmoCalculo()).log().parallel()
                    .runOn(Schedulers.parallel()).doOnNext(algoritmo -> calculoAlgoritmoFactory
                            .getAlgoritmo(algoritmo.getType()).execute(runProceso).onErrorResume(ex -> {
                                log.error(ex.getMessage(), ex);
                                return Flux.empty();
                            }).subscribe())
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new ReactorIcmclcwbException(e.getMessage(), e);
            }

            procesoService.modifyEstadoProceso(proceso, EstadoProcesoEnum.PENDIENTE_CONSOLIDACION.getDto());
        }
        return runProceso;
    }

}
