package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
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
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaAjustarServiceImpl implements RunTareaAjustarService {

  private final RunAjustePropertiesDto runAjusteProperties;

  private final AlgoritmoAjusteService algoritmoAjusteService;

  private final RunAjusteFactory runAjusteFactory;

  private final TareaFaseService tareaFaseService;

  private final TareaPersonaEstructuraPoliticaService tareaPersonaEstructuraPoliticaService;

  private final PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @Auditoria
  @Validation(fase = 7)
  @TimerFunctionalMetric(metricName = "RunTareaAjustarService.run.timer",
      metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaAjustarService.run.counter",
      metricGroupName = "RunTareaAjustarServiceGroup", metricDescription = "RunTareaAjustarService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    this.tareaFaseService.updateFechaInicio(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.AJUSTAR.getId()));
    final TareaDto tarea = runTarea.getTarea();
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    for (final Long pesos : this.algoritmoAjusteService.customFindAjustePesosByTarea(tarea.getId())) {
      for (final Integer id : this.algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(tarea.getId(),
          pesos)) {
        AsyncUtils.checkAsyncAvaliable(cf, this.runAjusteProperties.getThreadSize());
        final AlgoritmoAjusteDto algoritmo = this.algoritmoAjusteService.findById(id);
        final CompletableFuture<Void> cfRun = this.runAjusteFactory.getRunAjuste(algoritmo.getNombre())
            .execute(runTarea, algoritmo);
        AsyncUtils.exceptionally(cfRun, cf);
      }
      AsyncUtils.waitAllOfIsOk(cf, cf);
    }

    this.tareaFaseService.updateFechaFinAndEstado(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.AJUSTAR.getId()),
        EstadoTareaFaseEnum.OK.getDto());
  }

}
