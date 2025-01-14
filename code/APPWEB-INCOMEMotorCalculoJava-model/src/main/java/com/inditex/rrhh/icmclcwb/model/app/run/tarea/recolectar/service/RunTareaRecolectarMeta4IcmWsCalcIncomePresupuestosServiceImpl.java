package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService {

  private final RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

  @Override
  public void personaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .personaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosPresenciaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosDesplazamientoByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, item));
  }

}
