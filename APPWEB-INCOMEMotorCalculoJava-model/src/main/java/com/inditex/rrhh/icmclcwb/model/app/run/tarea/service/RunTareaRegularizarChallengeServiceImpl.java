package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.aqsw.framework.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRegularizarChallengeServiceImpl implements RunTareaRegularizarChallengeService {

  @Autowired
  private TareaPersonaHistoricoService tareaPersonaHistoricoService;

  @Autowired
  private TareaCalculoAsyncService tareaCalculoAsyncService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Value("${app.envars.tarea.regularizar.thread-size}")
  private Integer threadSize;

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

    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto : this.tareaPersonaHistoricoService
        .findIdPersonaLocalCompensacionChallengeByIdTarea(tarea.getId())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.threadSize);
      final CompletableFuture<Void> cfRun = this.tareaCalculoAsyncService.regularizarChallenge(runTarea,
          idPersonaLocalChallengeDto);
      AsyncUtils.exceptionally(cfRun, cf);
    }

    AsyncUtils.waitAllOfIsOk(cf, cf);

    this.tareaFaseService.updateFechaFinAndEstado(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.REGULARIZAR_CHALLENGE.getId()),
        EstadoTareaFaseEnum.OK.getDto());

  }

}
