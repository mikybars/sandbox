package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarByAmbitoServiceImpl implements RunTareaRecolectarByAmbitoService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralAsyncService runTareaRecolectarPtrVentaAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

    @Autowired
    private RunTareaRecolectarPivotAsyncService runTareaRecolectarPivotAsyncService;

    @Autowired
    private TareaTiendaEstadoAsyncService tareaTiendaEstadoAsyncService;

    @Autowired
    private TareaEmpleadoEstadoAsyncService tareaEmpleadoEstadoAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            CompletableFuture<Void> cfPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .personaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPersonaByRunTarea, cf, cfWait);

            CompletableFuture<Void> cfLocalizacionByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .localizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfLocalizacionByRunTarea, cf);

            CompletableFuture<Void> cfTiposHoras = runTareaRecolectarPtrPresenciaAsyncService
                    .tiposHorasByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiposHoras, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfCondicionPersonaByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .condicionPersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfCondicionPersonaByRunTarea, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runTarea;
    }

    @Deprecated
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto runPoC(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            final TareaDto tarea = runTarea.getTarea();
            final RunTareaRecolectarDto runTareaRecolectar = runTarea.getRunTareaRecolectar();

            CompletableFuture<Void> cfTiendasHistorico = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .tiendasHistorico(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

            if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/
                AsyncUtils.exceptionally(runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasEmpleadoHistorico(runTarea, runTareaRecolectar.getUno()), cf, cfWait);
            }

            CompletableFuture<Void> cfTiposHoras = runTareaRecolectarPtrPresenciaAsyncService
                    .tiposHorasByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiposHoras, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfTiendasComisionable = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .tiendasComisionable(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfTiendasComisionable, cf);

            CompletableFuture<Void> cfEmpleados = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .empleadosTienda(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfEmpleados, cf);

            CompletableFuture<Void> cfVentaTotalizadaTienda = runTareaRecolectarPtrVentaAsyncService
                    .ventaTotalizadaTienda(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

            CompletableFuture<Void> cfPresenciaTotalizadaTienda = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaTotalizadaTiendaSeccion(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfPresenciaDetalleEmpleado = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaDetalleComisionable(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

            CompletableFuture<Void> cfCondicionesEmpleados = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .condicionesEmpleados(runTarea, runTareaRecolectar.getUno());
            AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

            if (CollectionUtils.isNotEmpty(tarea.getLocalizacion()) || CollectionUtils.isNotEmpty(tarea.getPersona())) {
                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
                /*-------------------------------------------------------------*/
                if (CollectionUtils.isNotEmpty(runTareaRecolectar.getUno().getTiendaPresencia())) {
                    runTareaRecolectar.getUno().getTiendaPresencia().stream().forEach(item -> {
                        if (!runTareaRecolectar.getUno().getTiendaMeta4().contains(item)) {
                            runTareaRecolectar.getDos().getTiendaPresencia().add(item);
                        }
                    });
                    runTareaRecolectar.getDos().getTipoHoraComisionable()
                            .addAll(runTareaRecolectar.getUno().getTipoHoraComisionable());
                    runTareaRecolectar.getDos().getTipoHoraComisionableDenominador()
                            .addAll(runTareaRecolectar.getUno().getTipoHoraComisionableDenominador());

                    CompletableFuture<Void> cfTiendasPresencia = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                            .tiendasPresencia(runTarea, runTareaRecolectar.getDos());
                    AsyncUtils.exceptionally(cfTiendasPresencia, cf);

                    AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);

                    if (CollectionUtils.isNotEmpty(runTareaRecolectar.getDos().getTiendaMtu())) {
                        CompletableFuture<Void> cfTiendasComisionablePresencia = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                                .tiendasComisionable(runTarea, runTareaRecolectar.getDos());
                        AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);

                        CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = runTareaRecolectarPtrVentaAsyncService
                                .ventaTotalizadaTienda(runTarea, runTareaRecolectar.getDos());
                        AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                        CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = runTareaRecolectarPtrPresenciaAsyncService
                                .presenciaTotalizadaTiendaSeccion(runTarea, runTareaRecolectar.getDos());
                        AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                    }
                }
            }

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfPivot = runTareaRecolectarPivotAsyncService.pivot(runTarea);
            AsyncUtils.exceptionally(cfPivot, cf);

            CompletableFuture<Void> cftareaTiendaEstado = tareaTiendaEstadoAsyncService.save(runTareaRecolectar, tarea);
            AsyncUtils.exceptionally(cftareaTiendaEstado, cf);

            CompletableFuture<Void> cftareaEmpleadoEstado = tareaEmpleadoEstadoAsyncService.save(runTareaRecolectar,
                    tarea);
            AsyncUtils.exceptionally(cftareaEmpleadoEstado, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runTarea;
    }

}
