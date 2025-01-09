package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoFactory;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaCalcularServiceImpl implements RunTareaCalcularService {

  @Autowired
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Autowired
  private AlgoritmoService algoritmoService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Autowired
  private RunAlgoritmoFactory runAlgoritmoFactory;

  @Auditoria
  @Validation(fase = 4)
  @TimerFunctionalMetric(metricName = "RunTareaCalcularService.run.timer",
      metricGroupName = "RunTareaCalcularServiceGroup", metricDescription = "RunTareaCalcularService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaCalcularService.run.counter",
      metricGroupName = "RunTareaCalcularServiceGroup", metricDescription = "RunTareaCalcularService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    this.tareaFaseService.updateFechaInicio(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.CALCULAR.getId()));
    final TareaDto tarea = runTarea.getTarea();
    final List<CompletableFuture<?>> cf = new ArrayList<>();

    for (final Integer idAlgoritmo : this.algoritmoService.customFindAlgoritmosIdsByTarea(tarea.getId())) {
      AsyncUtils.checkAsyncAvaliable(cf, this.runAlgoritmoProperties.getThreadSize());
      final AlgoritmoDTO algoritmo = this.algoritmoService.findById(idAlgoritmo);
      final CompletableFuture<Void> cfRun = this.runAlgoritmoFactory.getRunAlgoritmo(algoritmo.getNombre())
          .execute(runTarea, algoritmo);
      AsyncUtils.exceptionally(cfRun, cf);
    }

    AsyncUtils.waitAllOfIsOk(cf, cf);

    this.tareaFaseService.updateFechaFinAndEstado(
        this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(runTarea.getTarea().getId(),
            FaseEnum.CALCULAR.getId()),
        EstadoTareaFaseEnum.OK.getDto());
  }

}
