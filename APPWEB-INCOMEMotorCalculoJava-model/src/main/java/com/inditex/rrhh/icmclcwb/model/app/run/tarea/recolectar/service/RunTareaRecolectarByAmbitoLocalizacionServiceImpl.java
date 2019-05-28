package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarByAmbitoLocalizacionServiceImpl
        implements RunTareaRecolectarByAmbitoLocalizacionService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            // Personas asociadas al ambito
            CompletableFuture<Void> cfPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .personaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPersonaByRunTarea, cf, cfWait);

            // Localizaciones asociadas al ambito
            CompletableFuture<Void> cfLocalizacionByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Personas asociadas a presencias de las localizaciones
            // (PTR: presenciaTiendasEmpleado)
            CompletableFuture<Void> cfPersonaPresenciaDetalle = runTareaRecolectarPtrPresenciaAsyncService
                    .personaPresenciaDetalleComisionableByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPersonaPresenciaDetalle, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // TODO Personas con desplazamientos entrantes a las tiendas
            // (Meta4: Falta el servicio)

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // TODO Personas con presencias manuales entrantes a las tiendas
            // (Meta4: Falta el servicio)

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Localizaciones asociadas a presencias de las personas
            // (PTR: presenciaTiendasEmpleado)
            CompletableFuture<Void> cfPresenciaTiendaEmpleado = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaTiendaEmpleadoByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciaTiendaEmpleado, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // TODO Localizaciones asociadas a presencias manuales salientes de las personas
            // (Meta4: Falta el servicio)

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // TODO Localizaciones asociadas a desplazamientos salientes de las personas
            // (Meta4: Falta el servicio)

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
