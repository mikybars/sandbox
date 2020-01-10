package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
@Validated
public class RunTareaAjustarServiceImpl implements RunTareaAjustarService{

    @Autowired
    private AlgoritmoAjusteService algoritmoAjusteService;
    
    @Autowired
    private RunAjusteFactory runAjusteFactory;
    
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
        Flux.fromIterable(algoritmoAjusteService.customFindAjusteIdsByTarea(tarea.getId())).parallel(1)
                .runOn(ItxSchedulers.elastic()).map(idAlgoritmo -> {
                    AlgoritmoAjusteDto ajuste = algoritmoAjusteService.findById(idAlgoritmo);
                    runAjusteFactory.getRunAjuste(ajuste.getNombre()).execute(runTarea);
                    return Flux.empty();
                }).sequential().collectList().block();
    }

}
