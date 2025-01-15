package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaConsolidarServiceImpl implements RunTareaConsolidarService {

  private final RunTareaConsolidarByAmbitoService runTareaConsolidarByAmbitoService;

  private final RunTareaConsolidarByAmbitoLocalizacionService runTareaConsolidarByAmbitoLocalizacionService;

  private final RunTareaConsolidarByAmbitoPersonaService runTareaConsolidarByAmbitoPersonaService;

  @Auditoria
  @Validation(fase = 9)
  @TimerFunctionalMetric(metricName = "RunTareaConsolidarService.run.timer",
      metricGroupName = "RunTareaConsolidarServiceGroup",
      metricDescription = "RunTareaConsolidarService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaConsolidarService.run.counter",
      metricGroupName = "RunTareaConsolidarServiceGroup",
      metricDescription = "RunTareaConsolidarService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    final TrabajoDTO trabajo = runTarea.getTrabajo();
    if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
        || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
        || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
      this.runTareaConsolidarByAmbitoService.run(runTarea);
    } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
      this.runTareaConsolidarByAmbitoLocalizacionService.run(runTarea);
    } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
      this.runTareaConsolidarByAmbitoPersonaService.run(runTarea);
    } else {
      throw new IcmclcwbException("El tipo ambito no esta soportado");
    }
  }

}
