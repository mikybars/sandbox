package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;

import reactor.core.publisher.Flux;

@Service
@Validated
public class RunTareaAjustarServiceImpl implements RunTareaAjustarService {

    @Autowired
    private AlgoritmoAjusteService algoritmoAjusteService;

    @Autowired
    private RunAjusteFactory runAjusteFactory;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaAjustarService.run.timer", metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaAjustarService.run.counter", metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.counter")
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        algoritmoAjusteService.customFindAjustePesosByTarea(tarea.getId()).stream().forEach(a -> 
            Flux.fromIterable(algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(tarea.getId(), a)).parallel()
            .runOn(ItxSchedulers.elastic()).map(algoritmo -> {
                AlgoritmoAjusteDto ajuste = algoritmoAjusteService.findById(algoritmo);
                runAjusteFactory.getRunAjuste(ajuste.getNombre()).execute(runTarea);
                return Flux.empty();
            }).sequential().collectList().block()
        );
    }

}
