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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarByAmbitoServiceImpl implements RunTareaRecolectarByAmbitoService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

    @Autowired
    private TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

    @Autowired
    private TareaLocalizacionPersonaAsyncService tareaLocalizacionPersonaAsyncService;

    @Autowired
    private TareaCalculoPersonaAsyncService tareaCalculoPersonaAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            // Personas asociadas al ambito
            CompletableFuture<Void> cfPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .personaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPersonaByRunTarea, cf);

            // Localizaciones asociadas al ambito
            CompletableFuture<Void> cfLocalizacionByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Relacion de personas en localizaciones según presencias reales
            CompletableFuture<Void> cfPresenciaEmpleadoTienda = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaEmpleadoTiendaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciaEmpleadoTienda, cf);

            // Relacion de personas en localizaciones según presencias manuales
            CompletableFuture<Void> cfEmpleadosPresencia = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .empleadosPresenciaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEmpleadosPresencia, cf);

            // Relacion de personas en localizaciones según desplazamientos
            // TODO Falta el servicio de Meta4

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfMergePersonaLocalizacion = tareaLocalizacionPersonaAsyncService
                    .mergePersonaLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfMergePersonaLocalizacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfMergePersona = tareaAmbitoGlobalPersonaAsyncService.mergePersona(runTarea);
            AsyncUtils.exceptionally(cfMergePersona, cf);

            CompletableFuture<Void> cfMergeLocalizacion = tareaAmbitoGlobalLocalizacionAsyncService.mergeLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfMergeLocalizacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfMergePersonaCalculo = tareaCalculoPersonaAsyncService
                    .mergePersonaCalculo(runTarea);
            AsyncUtils.exceptionally(cfMergePersonaCalculo, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
