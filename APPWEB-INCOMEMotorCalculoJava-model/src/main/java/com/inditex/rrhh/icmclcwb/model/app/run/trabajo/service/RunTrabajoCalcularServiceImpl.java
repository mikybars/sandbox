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
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.CalculoAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.TipoCalculoEnum;

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
    private CalculoAlgoritmoFactory calculoAlgoritmoFactory;

    @CounterMetric
    @TimerMetric
    @RunTrabajoAuditoria
    @Override
    public RunTrabajoDto run(@Valid final RunTrabajoDto runTrabajo) throws Exception {
        TrabajoDto trabajo = runTrabajo.getTrabajoDto();
        if (EstadoTrabajoEnum.PENDIENTE_CALCULO.getId().equals(trabajo.getEstado().getId())) {
            trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.EN_CURSO_CALCULO.getDto());

            // TODO Pendiente revisar los identificadores a utilizar, si hace el tipo de
            // comision, etc...
            runTrabajo.getRunTrabajoCalcular().getTiposCalculo()
                    .addAll(trabajoEmpleadoEstructuraService.findIdsEstructuraByIdTrabajo(trabajo.getId()));

            runTrabajo.getRunTrabajoCalcular().getIdsEmpleados().addAll(trabajoEmpleadoEstadoService
                    .findIdsEmpleadoByIdTrabajo(trabajo.getId(), EstadoTrabajoEnum.PENDIENTE_CALCULO.getId()));

            // TODO Tratamiento de errores
            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(runTrabajo.getRunTrabajoCalcular().getTiposCalculo()).log().parallel()
                    .runOn(Schedulers.parallel())
                    .doOnNext(tipo -> calculoAlgoritmoFactory.getAlgoritmo(TipoCalculoEnum.of(tipo).getType())
                            .execute(runTrabajo).onErrorResume(error -> {
                                log.error(error.getMessage());
                                return Flux.empty();
                            }).subscribe())
                    .doOnError(error -> log.error(error.getMessage())).doAfterTerminate(latch::countDown).subscribe();
            latch.await();

            trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.PENDIENTE_CONSOLIDACION.getDto());
        }
        return runTrabajo;
    }

}
