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
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarAmbitoServiceImpl implements RunTareaRecolectarAmbitoService {

    @Autowired
    private RunTareaRecolectarByAmbitoService runTareaRecolectarByAmbitoService;

    @Autowired
    private RunTareaRecolectarByAmbitoLocalizacionService runTareaRecolectarByAmbitoLocalizacionService;

    @Autowired
    private RunTareaRecolectarByAmbitoPersonaService runTareaRecolectarByAmbitoPersonaService;

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

    @Autowired
    private TareaAmbitoGlobalPersonaAsyncService tareaAmbitoGlobalPersonaAsyncService;

    @Autowired
    private TareaAmbitoGlobalLocalizacionAsyncService tareaAmbitoGlobalLocalizacionAsyncService;
    
    @Autowired
    private TareaAmbitoGlobalLocalizacionPersonaAsyncService tareaAmbitoGlobalLocalizacionPersonaAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            // Personas asociadas al origen y empresa
            CompletableFuture<Void> cfPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .personaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPersonaByRunTarea, cf);

            // Localizaciones asociadas al origen y empresa
            CompletableFuture<Void> cfLocalizacionByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Relacion de personas con localizaciones en presencias ptr
            // asociadas al origen y empresa
            CompletableFuture<Void> cfPresenciaEmpleadoTienda = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaEmpleadoTiendaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciaEmpleadoTienda, cf);

            // Relacion de personas con localizaciones en presencias manuales
            // asociadas al origen y empresa
            CompletableFuture<Void> cfEmpleadosPresencia = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .empleadosPresenciaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfEmpleadosPresencia, cf);

            // Relacion de personas con localizaciones en desplazamientos
            // asociadas al origen y empresa
            //CompletableFuture<Void> cfEmpleadosDesplazamiento = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
            //        .empleadosDesplazamientoByRunTarea(runTarea);
            //AsyncUtils.exceptionally(cfEmpleadosDesplazamiento, cf);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfMergePersonaLocalizacion = tareaAmbitoGlobalLocalizacionPersonaAsyncService
                    .mergePersonaLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfMergePersonaLocalizacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfMergePersona = tareaAmbitoGlobalPersonaAsyncService.mergePersona(runTarea);
            AsyncUtils.exceptionally(cfMergePersona, cf);

            CompletableFuture<Void> cfMergeLocalizacion = tareaAmbitoGlobalLocalizacionAsyncService
                    .mergeLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfMergeLocalizacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
                    || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
                    || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {
                runTareaRecolectarByAmbitoService.run(runTarea);
            } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(trabajo.getTipoAmbito().getId())) {
                runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
            } else if (TipoAmbitoEnum.PERSONA.getId().equals(trabajo.getTipoAmbito().getId())) {
                runTareaRecolectarByAmbitoPersonaService.run(runTarea);
            } else {
                throw new IcmclcwbException("El tipo ambito no esta soportado");
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
