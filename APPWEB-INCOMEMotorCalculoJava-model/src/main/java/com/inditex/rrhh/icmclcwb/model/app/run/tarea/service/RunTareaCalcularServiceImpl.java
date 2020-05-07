
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
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;
import reactor.core.publisher.Flux;

@Service
@Validated
public class RunTareaCalcularServiceImpl implements RunTareaCalcularService {

    @Autowired
    private RunAlgoritmoFactory runAlgoritmoFactory;

    @Autowired
    private AlgoritmoService algoritmoService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaCalcularService.run.timer",
            metricGroupName = "RunTareaCalcularServiceGroup", metricDescription = "RunTareaCalcularService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaCalcularService.run.counter",
            metricGroupName = "RunTareaCalcularServiceGroup", metricDescription = "RunTareaCalcularService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        Flux.fromIterable(algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId()))
            .parallel()
            .runOn(ItxSchedulers.elastic())
            .map(idAlgoritmo -> {
                AlgoritmoDto algoritmo = algoritmoService.findById(idAlgoritmo);
                runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre()).execute(runTarea, algoritmo);
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

}
