package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarServiceImpl implements RunTareaRecolectarService {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaRecolectarMeta4IcmWsCalcIncomeAsyncService tareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private TareaRecolectarPtrVentaAsyncService tareaRecolectarPtrVentaAsyncService;

    @Autowired
    private TareaRecolectarPtrPresenciaAsyncService tareaRecolectarPtrPresenciaAsyncService;

    @Autowired
    private TareaPivotAsyncService tareaPivotAsyncService;

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
            final TareaDto tarea = tareaService.find(runTarea.getTarea().getId());
            final RunTareaRecolectarDto runTareaRecolectar = runTarea.getRunTareaRecolectar();
            if (EstadoTareaEnum.PENDIENTE_RECOLECTAR.getId().equals(tarea.getEstado().getId())) {
                tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.EN_CURSO_RECOLECTAR.getDto());
                
                CompletableFuture<Void> cfTiendasHistorico = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasHistorico(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

                if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())) {
                    /*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfWait);
                    /*-------------------------------------------------------------*/
                    AsyncUtils.exceptionally(tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                            .tiendasEmpleadoHistorico(tarea, runTareaRecolectar.getUno()), cf, cfWait);
                }

                CompletableFuture<Void> cfTiposHoras = tareaRecolectarPtrPresenciaAsyncService.tiposHoras(tarea,
                        runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiposHoras, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfTiendasComisionable = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasComisionable(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasComisionable, cf);

                CompletableFuture<Void> cfEmpleados = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .empleadosTienda(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfEmpleados, cf);

                CompletableFuture<Void> cfVentaTotalizadaTienda = tareaRecolectarPtrVentaAsyncService
                        .ventaTotalizadaTienda(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = tareaRecolectarPtrPresenciaAsyncService
                        .presenciaTotalizadaTienda(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPresenciaDetalleEmpleado = tareaRecolectarPtrPresenciaAsyncService
                        .presenciaDetalleEmpleado(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

                CompletableFuture<Void> cfCondicionesEmpleados = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .condicionesEmpleados(tarea, runTareaRecolectar.getUno());
                AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

                if (CollectionUtils.isNotEmpty(tarea.getLocalizacion())
                        || CollectionUtils.isNotEmpty(tarea.getPersona())) {
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

                        CompletableFuture<Void> cfTiendasPresencia = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                                .tiendasPresencia(tarea, runTareaRecolectar.getDos());
                        AsyncUtils.exceptionally(cfTiendasPresencia, cf);

                        AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);

                        if (CollectionUtils.isNotEmpty(runTareaRecolectar.getDos().getTiendaMtu())) {
                            CompletableFuture<Void> cfTiendasComisionablePresencia = tareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                                    .tiendasComisionable(tarea, runTareaRecolectar.getDos());
                            AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);

                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = tareaRecolectarPtrVentaAsyncService
                                    .ventaTotalizadaTienda(tarea, runTareaRecolectar.getDos());
                            AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = tareaRecolectarPtrPresenciaAsyncService
                                    .presenciaTotalizadaTienda(tarea, runTareaRecolectar.getDos());
                            AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                        }
                    }
                }

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPivot = tareaPivotAsyncService.pivot(tarea);
                AsyncUtils.exceptionally(cfPivot, cf);

                CompletableFuture<Void> cftareaTiendaEstado = tareaTiendaEstadoAsyncService
                        .save(runTareaRecolectar, tarea);
                AsyncUtils.exceptionally(cftareaTiendaEstado, cf);

                CompletableFuture<Void> cftareaEmpleadoEstado = tareaEmpleadoEstadoAsyncService
                        .save(runTareaRecolectar, tarea);
                AsyncUtils.exceptionally(cftareaEmpleadoEstado, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                
                tareaService.modifyEstadoTarea(tarea, EstadoTareaEnum.PENDIENTE_CALCULAR.getDto());
            }
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runTarea;
    }

}
