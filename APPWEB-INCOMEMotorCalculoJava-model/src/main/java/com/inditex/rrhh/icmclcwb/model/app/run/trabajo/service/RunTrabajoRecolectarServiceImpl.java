package com.inditex.rrhh.icmclcwb.model.app.run.trabajo.service;

import java.time.LocalDateTime;
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
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTrabajoAuditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoRecolectarPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTrabajoRecolectarServiceImpl implements RunTrabajoRecolectarService {

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncService trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private TrabajoRecolectarPtrVentaAsyncService trabajoRecolectarPtrVentaAsyncService;

    @Autowired
    private TrabajoRecolectarPtrPresenciaAsyncService trabajoRecolectarPtrPresenciaAsyncService;
    
    @Autowired
    private TrabajoPivotAsyncService trabajoPivotAsyncService;
    
    @Autowired
    private TrabajoTiendaEstadoAsyncService trabajoTiendaEstadoAsyncService;
    
    @Autowired
    private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

    @CounterMetric
    @TimerMetric
    @RunTrabajoAuditoria
    @Override
    public RunTrabajoDto run(@Valid final RunTrabajoDto runTrabajo) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTrabajo.getTrabajoDto();
            final RunTrabajoRecolectarDto runTrabajoRecolectar = runTrabajo.getRunTrabajoRecolectar();
            if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
                trabajo.setFechaInicioTrabajo(LocalDateTime.now());
                trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
                trabajoService.modifyTrabajo(trabajo);

                CompletableFuture<Void> cfTiendasHistorico = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasHistorico(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

                if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                	/*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfWait);
                    /*-------------------------------------------------------------*/
                    AsyncUtils.exceptionally(trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                            .tiendasEmpleadoHistorico(trabajo, runTrabajoRecolectar.getUno()), cf, cfWait);
                }

                CompletableFuture<Void> cfTiposHoras = trabajoRecolectarPtrPresenciaAsyncService.tiposHoras(trabajo);
                AsyncUtils.exceptionally(cfTiposHoras, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfTiendasComisionable = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .tiendasComisionable(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfTiendasComisionable, cf);

                CompletableFuture<Void> cfEmpleados = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .empleadosTienda(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfEmpleados, cf);               
                
                CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoRecolectarPtrVentaAsyncService
                        .ventaTotalizadaTienda(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoRecolectarPtrPresenciaAsyncService
                        .presenciaTotalizadaTienda(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoRecolectarPtrPresenciaAsyncService
                        .presenciaDetalleEmpleado(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

                // TODO  
//                CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoRecolectarPtrVentaAsyncService
//                        .ventaDetalleEmpleado(trabajo, runTrabajoRecolectar.getUno());
//                AsyncUtils.exceptionally(cfVentaDetalleEmpleado, cf);

                CompletableFuture<Void> cfCondicionesEmpleados = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                        .condicionesEmpleados(trabajo, runTrabajoRecolectar.getUno());
                AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

                if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                        || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                    /*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
                    /*-------------------------------------------------------------*/
                    if (CollectionUtils.isNotEmpty(runTrabajoRecolectar.getUno().getTiendaPresencia())) {
                        runTrabajoRecolectar.getUno().getTiendaPresencia().stream().forEach(item -> {
                            if(!runTrabajoRecolectar.getUno().getTiendaMeta4().contains(item)) {
                                runTrabajoRecolectar.getDos().getTiendaPresencia().add(item);
                            }
                        });
                        
                        CompletableFuture<Void> cfTiendasPresencia = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                                .tiendasPresencia(trabajo, runTrabajoRecolectar.getDos());
                        AsyncUtils.exceptionally(cfTiendasPresencia, cf);

                        AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);

                        if (CollectionUtils.isNotEmpty(runTrabajoRecolectar.getDos().getTiendaMtu())) {
                            CompletableFuture<Void> cfTiendasComisionablePresencia = trabajoRecolectarMeta4IcmWsCalcIncomeAsyncService
                                    .tiendasComisionable(trabajo, runTrabajoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);

                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoRecolectarPtrVentaAsyncService
                                    .ventaTotalizadaTienda(trabajo, runTrabajoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoRecolectarPtrPresenciaAsyncService
                                    .presenciaTotalizadaTienda(trabajo, runTrabajoRecolectar.getDos());
                            AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                        }
                    }
                }
                
                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                
                CompletableFuture<Void> cfPivot = trabajoPivotAsyncService.pivot(trabajo);
                AsyncUtils.exceptionally(cfPivot, cf);

                CompletableFuture<Void> cftrabajoTiendaEstado = trabajoTiendaEstadoAsyncService.save(runTrabajoRecolectar, trabajo);
                AsyncUtils.exceptionally(cftrabajoTiendaEstado, cf);

                CompletableFuture<Void> cftrabajoEmpleadoEstado = trabajoEmpleadoEstadoAsyncService.save(runTrabajoRecolectar, trabajo);
                AsyncUtils.exceptionally(cftrabajoEmpleadoEstado, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                trabajoService.modifyEstadoTrabajo(trabajo, EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto());                                                        
               
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runTrabajo;
    }

}
