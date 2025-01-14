package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaPresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarAmbitoPresupuestoServiceImpl implements RunTareaRecolectarAmbitoPresupuestoService {

  private final RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  private final RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;

  private final TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  private final TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

  private final TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

  private final TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

  private final RunTareaRecolectarPtrPresenciaPresupuestosAsyncService runTareaRecolectarPtrPresenciaPresupuestosAsyncService;

  private final RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

  private final RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

  private final RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

  private final LimpiezaAsyncService limpiezaAsyncService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.timer",
      metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup",
      metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.counter",
      metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup",
      metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.counter")
  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    try {
      /*-----------------------------------------------------------------*/
      /*
       * Carga inicial de estructuras
       */
      /*-----------------------------------------------------------------*/

      // Estructuras (Tramado estructuras (ApV) Detalle comision (Meta4))
      final CompletableFuture<Void> cfEstructurasCom = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .estructurasComByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEstructurasCom, cf);

      final CompletableFuture<Void> cfEstructurasPol = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .estructurasPolByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEstructurasPol, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      final CompletableFuture<Void> cfPresupuestos = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .presupuestosWlocByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresupuestos, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

      final TareaLocalizacionPresupuestoListDto presupuestos = this.tareaLocalizacionPresupuestoService
          .findPresupuestos(runTarea.getTarea());
      if (presupuestos.esAmbitoAmpliado(runTarea.getTarea())) {

        final TrabajoDTO trabajo = runTarea.getTrabajo();
        /*-----------------------------------------------------------------*/
        /*
         * Limpieza del ámbito anterior
         */
        /*-----------------------------------------------------------------*/

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalPersona = this.limpiezaAsyncService
            .limpiezaTareaAmbitoGlobalPersona(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalPersona, cf);

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoLocalizacion = this.limpiezaAsyncService
            .limpiezaTareaAmbitoLocalizacion(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoLocalizacion, cf);

        final CompletableFuture<Void> cfLimpiezaTareaPersonaHistorico = this.limpiezaAsyncService
            .limpiezaTareaPersonaHistorico(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaPersonaHistorico, cf);

        final CompletableFuture<Void> cfLimpiezaTareaLocalizacionHistorico = this.limpiezaAsyncService
            .limpiezaTareaLocalizacionHistorico(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaLocalizacionHistorico, cf);

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersona = this.limpiezaAsyncService
            .limpiezaTareaGlobalLocalizacionPersona(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersona, cf);

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento = this.limpiezaAsyncService
            .limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento, cf);

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia = this.limpiezaAsyncService
            .limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia, cf);

        final CompletableFuture<Void> cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual = this.limpiezaAsyncService
            .limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(runTarea.getTarea());
        AsyncUtils.exceptionally(cfLimpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/

        /*-----------------------------------------------------------------*/
        /*
         * Obtención del ámbito de nuevo con el nuevo rango de fechas procedente de los presupuestos.
         */
        /*-----------------------------------------------------------------*/

        // Personas asociadas al origen y empresa
        final CompletableFuture<Void> cfPersonaByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
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
        final CompletableFuture<Void> cfPresenciaEmpleadoTienda = this.runTareaRecolectarPtrPresenciaPresupuestosAsyncService
            .presenciaEmpleadoTiendaByRunTarea(runTarea);
        AsyncUtils.exceptionally(cfPresenciaEmpleadoTienda, cf);

        // Relacion de personas con localizaciones en presencias manuales
        // asociadas al origen y empresa
        final CompletableFuture<Void> cfEmpleadosPresencia = this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
            .empleadosPresenciaByRunTarea(runTarea);
        AsyncUtils.exceptionally(cfEmpleadosPresencia, cf);

        // Relacion de personas con localizaciones en desplazamientos
        // asociadas al origen y empresa
        final CompletableFuture<Void> cfEmpleadosDesplazamiento = this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService
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

        // Nota: las acciones a continuación no dependen de un rango de fechas, por lo que no se crean
        // servicios específicos para Presupuestos, se reutilizan los ya existentes de la recolección
        // del ámbito.

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
      }

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
