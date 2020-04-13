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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;

import reactor.core.publisher.Flux;

@Service
@Validated
public class RunTareaRegularizarChallengeServiceImpl implements RunTareaRegularizarChallengeService {

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;
    
    @Autowired
    private TareaCalculoService tareaCalculoService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaRegularizarChallengeService.run.timer", metricGroupName = "RunTareaRegularizarChallengeServiceGroup", metricDescription = "RunTareaRegularizarChallengeService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRegularizarChallengeService.run.counter", metricGroupName = "RunTareaRegularizarChallengeServiceGroup", metricDescription = "RunTareaRegularizarChallengeService.run.counter")
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        TareaDto tarea = runTarea.getTarea();
            Flux.fromIterable(tareaPersonaHistoricoService.findIdPersonaLocalCompensacionChallengeByIdTarea(tarea.getId())).parallel()
            .runOn(ItxSchedulers.elastic()).map(x -> {
                tareaCalculoService.regularizarChallenge(runTarea, x);
                return Flux.empty();
            }).sequential().collectList().block();

    }

}
