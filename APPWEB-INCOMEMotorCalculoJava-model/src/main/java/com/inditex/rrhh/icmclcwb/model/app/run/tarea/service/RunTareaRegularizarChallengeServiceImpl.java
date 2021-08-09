package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaRegularizarChallengeServiceImpl implements RunTareaRegularizarChallengeService {

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;

    @Autowired
    private TareaCalculoService tareaCalculoService;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Auditoria
    @Validation(fase = 5)
    @TimerFunctionalMetric(metricName = "RunTareaRegularizarChallengeService.run.timer",
            metricGroupName = "RunTareaRegularizarChallengeServiceGroup",
            metricDescription = "RunTareaRegularizarChallengeService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRegularizarChallengeService.run.counter",
            metricGroupName = "RunTareaRegularizarChallengeServiceGroup",
            metricDescription = "RunTareaRegularizarChallengeService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        this.tareaFaseService.updateFechaInicio(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.REGULARIZAR_CHALLENGE.getId()));
        final TareaDto tarea = runTarea.getTarea();
        final Scheduler s = Schedulers.newElastic("async-reactor-regularizar");
        Flux.fromIterable(
                this.tareaPersonaHistoricoService.findIdPersonaLocalCompensacionChallengeByIdTarea(tarea.getId()))
            .parallel()
            .runOn(s)
            .map(x -> {
                this.tareaCalculoService.regularizarChallenge(runTarea, x);
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
        s.dispose();

        this.tareaFaseService.updateFechaFinAndEstado(
                this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
                        FaseEnum.REGULARIZAR_CHALLENGE.getId()),
                EstadoTareaFaseEnum.OK.getDto());

    }

}
