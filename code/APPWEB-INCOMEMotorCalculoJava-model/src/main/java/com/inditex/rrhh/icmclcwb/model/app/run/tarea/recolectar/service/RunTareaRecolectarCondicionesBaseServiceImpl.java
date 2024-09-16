package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesBaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.AccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarCondicionesBaseServiceImpl implements RunTareaRecolectarCondicionesBaseService {

  @Autowired
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Autowired
  private RunTareaPrevalidarDuranteService runTareaPrevalidarDuranteService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarCondicionesBaseService.run.timer",
      metricGroupName = "RunTareaRecolectarCondicionesBaseService",
      metricDescription = "RunTareaRecolectarCondicionesBaseService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarCondicionesBaseService.run.counter",
      metricGroupName = "RunTareaRecolectarCondicionesBaseService",
      metricDescription = "RunTareaRecolectarCondicionesBaseService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
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

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.CONDICIONES_HISTORICO.getDto());

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.DESPLAZAMIENTO.getDto());

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.MOTIVOS.getDto());

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.FECHAS.getDto());

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.BAJA.getDto());

      final CompletableFuture<Void> cfPresupuestos = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .presupuestosWlocByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresupuestos, cf);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/

    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
