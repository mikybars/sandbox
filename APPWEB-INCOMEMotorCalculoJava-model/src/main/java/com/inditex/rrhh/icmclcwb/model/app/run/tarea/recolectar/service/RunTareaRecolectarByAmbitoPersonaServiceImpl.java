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
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarByAmbitoPersonaServiceImpl implements RunTareaRecolectarByAmbitoPersonaService {

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

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Localizaciones asociadas al historico de personas
            CompletableFuture<Void> cfTiendasHistorico = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionHistoricoByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

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
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
