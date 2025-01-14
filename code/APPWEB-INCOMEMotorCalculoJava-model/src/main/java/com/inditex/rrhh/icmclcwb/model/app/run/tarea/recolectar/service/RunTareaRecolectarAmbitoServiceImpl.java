package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarAmbitoServiceImpl implements RunTareaRecolectarAmbitoService {

  private final RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

  private final RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

  private final RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

  private final RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  private final RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

  private final TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

  private final TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

  private final TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarAmbitoService.run.timer",
      metricGroupName = "RunTareaRecolectarAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarAmbitoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarAmbitoService.run.counter",
      metricGroupName = "RunTareaRecolectarAmbitoServiceGroup",
      metricDescription = "RunTareaRecolectarAmbitoService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      // Personas asociadas al origen y empresa
      final CompletableFuture<Void> cfPersonaByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .personaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPersonaByRunTarea, cf);

      // Localizaciones asociadas al origen y empresa
      final CompletableFuture<Void> cfLocalizacionByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .localizacionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      // Relacion de personas con localizaciones en presencias ptr
      // asociadas al origen y empresa
      final CompletableFuture<Void> cfPresenciaEmpleadoTienda = this.runTareaRecolectarPtrPresenciaAsyncService
          .presenciaEmpleadoTiendaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresenciaEmpleadoTienda, cf);

      // Relacion de personas con localizaciones en presencias manuales
      // asociadas al origen y empresa
      final CompletableFuture<Void> cfEmpleadosPresencia = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .empleadosPresenciaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEmpleadosPresencia, cf);

      // Relacion de personas con localizaciones en desplazamientos
      // asociadas al origen y empresa
      final CompletableFuture<Void> cfEmpleadosDesplazamiento = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .empleadosDesplazamientoByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEmpleadosDesplazamiento, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      final CompletableFuture<Void> cfMergePersonaLocalizacion = this.tareaAmbitoGlobalLocalizacionPersonaAsyncService
          .mergePersonaLocalizacion(runTarea);
      AsyncUtils.exceptionally(cfMergePersonaLocalizacion, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      final CompletableFuture<Void> cfMergePersona = this.tareaAmbitoGlobalPersonaAsyncService
          .mergePersona(runTarea);
      AsyncUtils.exceptionally(cfMergePersona, cf);

      final CompletableFuture<Void> cfMergeLocalizacion = this.tareaAmbitoGlobalLocalizacionAsyncService
          .mergeLocalizacion(runTarea);
      AsyncUtils.exceptionally(cfMergeLocalizacion, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
      if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
          || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
          || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
        this.runTareaRecolectarByAmbitoService.run(runTarea);
      } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
        this.runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
      } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
        this.runTareaRecolectarByAmbitoPersonaService.run(runTarea);
      } else {
        throw new IcmclcwbException("El tipo ambito no esta soportado");
      }
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
