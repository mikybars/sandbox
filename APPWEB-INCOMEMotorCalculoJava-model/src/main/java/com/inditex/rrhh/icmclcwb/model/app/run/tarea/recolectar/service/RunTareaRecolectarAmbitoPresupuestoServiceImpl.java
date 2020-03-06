package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarAmbitoPresupuestoService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Validated
public class RunTareaRecolectarAmbitoPresupuestoServiceImpl implements RunTareaRecolectarAmbitoPresupuestoService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.timer", metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup", metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaRecolectarAmbitoPresupuestoService.run.counter", metricGroupName = "RunTareaRecolectarAmbitoPresupuestoServiceGroup", metricDescription = "RunTareaRecolectarAmbitoPresupuestoService.run.counter")
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            /*-----------------------------------------------------------------*/
            /*
             * Carga inicial de estructuras
             */
            /*-----------------------------------------------------------------*/

            // Estructuras (Tramado estructuras (ApV) Detalle comision (Meta4))
            CompletableFuture<Void> cfEstructurasCom = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .estructurasComByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEstructurasCom, cf, cfWait);

            CompletableFuture<Void> cfEstructurasPol = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .estructurasPolByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEstructurasPol, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfPresupuestos = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresupuestos, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
