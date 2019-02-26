package com.inditex.rrhh.icmclcwb.model.app.run.proceso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunProcesoRecolectarServiceImpl implements RunProcesoRecolectarService {

    @Autowired
    private ProcesoService procesoService;

    @Autowired
    private ProcesoRecolectarMeta4IcmWsCalcIncomeAsyncService procesoRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private ProcesoRecolectarPtrVentaAsyncService procesoRecolectarPtrVentaAsyncService;

    @Autowired
    private ProcesoRecolectarPtrPresenciaAsyncService procesoRecolectarPtrPresenciaAsyncService;

    @Autowired
    private ProcesoPivotAsyncService procesoPivotAsyncService;

    @Autowired
    private ProcesoTiendaEstadoAsyncService procesoTiendaEstadoAsyncService;

    @Autowired
    private ProcesoEmpleadoEstadoAsyncService procesoEmpleadoEstadoAsyncService;

    @CounterMetric
    @TimerMetric
    @Auditoria
    @Override
    public RunProcesoDto run(@Valid final RunProcesoDto runProceso) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            final ProcesoDto proceso = runProceso.getProceso();
            final RunProcesoRecolectarDto runProcesoRecolectar = runProceso.getRunProcesoRecolectar();
            if (EstadoProcesoEnum.PENDIENTE_DATOS.getId().equals(proceso.getEstado().getId())) {
                procesoService.modifyEstadoProcesoInicial(proceso, EstadoProcesoEnum.EN_CURSO_DATOS.getDto());

                CompletableFuture<Void> cfTiendasHistorico = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasHistorico(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

                if (CollectionUtils.isNotEmpty(proceso.getTiendas())) {
                    /*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfWait);
                    /*-------------------------------------------------------------*/
                    AsyncUtils.exceptionally(procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                            .tiendasEmpleadoHistorico(proceso, runProcesoRecolectar.getUno()), cf, cfWait);
                }

                CompletableFuture<Void> cfTiposHoras = procesoRecolectarPtrPresenciaAsyncService.tiposHoras(proceso,
                        runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiposHoras, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfTiendasComisionable = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasComisionable(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasComisionable, cf);

                CompletableFuture<Void> cfEmpleados = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .empleadosTienda(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfEmpleados, cf);

                CompletableFuture<Void> cfVentaTotalizadaTienda = procesoRecolectarPtrVentaAsyncService
                        .ventaTotalizadaTienda(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = procesoRecolectarPtrPresenciaAsyncService
                        .presenciaTotalizadaTienda(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPresenciaDetalleEmpleado = procesoRecolectarPtrPresenciaAsyncService
                        .presenciaDetalleEmpleado(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

                CompletableFuture<Void> cfCondicionesEmpleados = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .condicionesEmpleados(proceso, runProcesoRecolectar.getUno());
                AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

                if (CollectionUtils.isNotEmpty(proceso.getTiendas())
                        || CollectionUtils.isNotEmpty(proceso.getEmpleados())) {
                    /*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
                    /*-------------------------------------------------------------*/
                    if (CollectionUtils.isNotEmpty(runProcesoRecolectar.getUno().getTiendaPresencia())) {
                        runProcesoRecolectar.getUno().getTiendaPresencia().stream().forEach(item -> {
                            if (!runProcesoRecolectar.getUno().getTiendaMeta4().contains(item)) {
                                runProcesoRecolectar.getDos().getTiendaPresencia().add(item);
                            }
                        });
                        runProcesoRecolectar.getDos().getTipoHoraComisionable()
                                .addAll(runProcesoRecolectar.getUno().getTipoHoraComisionable());
                        runProcesoRecolectar.getDos().getTipoHoraComisionableDenominador()
                                .addAll(runProcesoRecolectar.getUno().getTipoHoraComisionableDenominador());

                        CompletableFuture<Void> cfTiendasPresencia = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                                .tiendasPresencia(proceso, runProcesoRecolectar.getDos());
                        AsyncUtils.exceptionally(cfTiendasPresencia, cf);

                        AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);

                        if (CollectionUtils.isNotEmpty(runProcesoRecolectar.getDos().getTiendaMtu())) {
                            CompletableFuture<Void> cfTiendasComisionablePresencia = procesoRecolectarMeta4IcmWsCalcIncomeAsyncService
                                    .tiendasComisionable(proceso, runProcesoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);

                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = procesoRecolectarPtrVentaAsyncService
                                    .ventaTotalizadaTienda(proceso, runProcesoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = procesoRecolectarPtrPresenciaAsyncService
                                    .presenciaTotalizadaTienda(proceso, runProcesoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                        }
                    }
                }

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPivot = procesoPivotAsyncService.pivot(proceso);
                AsyncUtils.exceptionally(cfPivot, cf);

                CompletableFuture<Void> cfprocesoTiendaEstado = procesoTiendaEstadoAsyncService
                        .save(runProcesoRecolectar, proceso);
                AsyncUtils.exceptionally(cfprocesoTiendaEstado, cf);

                CompletableFuture<Void> cfprocesoEmpleadoEstado = procesoEmpleadoEstadoAsyncService
                        .save(runProcesoRecolectar, proceso);
                AsyncUtils.exceptionally(cfprocesoEmpleadoEstado, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                procesoService.modifyEstadoProceso(proceso, EstadoProcesoEnum.PENDIENTE_CALCULO.getDto());
            }
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runProceso;
    }

}
