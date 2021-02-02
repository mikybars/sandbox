package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaAjustarServiceImpl implements RunTareaAjustarService {

    @Autowired
    private AlgoritmoAjusteService algoritmoAjusteService;

    @Autowired
    private RunAjusteFactory runAjusteFactory;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Auditoria
    @Validation
    @TimerFunctionalMetric(metricName = "RunTareaAjustarService.run.timer",
            metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaAjustarService.run.counter",
            metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        this.tareaFaseService.updateFechaInicio(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.AJUSTAR.getId()));
        final TareaDto tarea = runTarea.getTarea();
        this.algoritmoAjusteService.customFindAjustePesosByTarea(tarea.getId())
            .stream()
            .forEach(a -> Flux
                .fromIterable(this.algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(tarea.getId(), a))
                .parallel()
                .runOn(Schedulers.newElastic("async-reactor-ajustar"))
                .map(algoritmo -> {
                    final AlgoritmoAjusteDto ajuste = this.algoritmoAjusteService.findById(algoritmo);
                    this.runAjusteFactory.getRunAjuste(ajuste.getNombre()).execute(runTarea, ajuste);
                    return Flux.empty();
                })
                .sequential()
                .collectList()
                .block());
        this.tareaFaseService.updateFechaFinAndEstado(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.AJUSTAR.getId()),
                EstadoTareaFaseEnum.OK.getDto());
    }

}
