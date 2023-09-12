package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService {

  @Autowired
  private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;

  @Override
  public CompletableFuture<Void> personaByRunTarea(RunTareaDto runTarea) {
    runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.personaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> localizacionByRunTarea(RunTareaDto runTarea) {
    runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.localizacionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> empleadosPresenciaByRunTarea(RunTareaDto runTarea) {
    runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.empleadosPresenciaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> empleadosDesplazamientoByRunTarea(RunTareaDto runTarea) {
    runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService.empleadosDesplazamientoByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
