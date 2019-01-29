package com.inditex.rrhh.icmclcwb.model.app.service;

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
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoDatosPtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoPivotAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunDatosService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants.EstadoTrabajoEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class TrabajoRunDatosServiceImpl implements TrabajoRunDatosService {

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoDatosMeta4IcmWsCalcIncomeAsyncService trabajoDatosMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private TrabajoDatosPtrVentaAsyncService trabajoDatosPtrVentaAsyncService;

    @Autowired
    private TrabajoDatosPtrPresenciaAsyncService trabajoDatosPtrPresenciaAsyncService;
    
    @Autowired
    private TrabajoPivotAsyncService trabajoPivotAsyncService;
    
    @Autowired
    private TrabajoTiendaEstadoAsyncService trabajoTiendaEstadoAsyncService;
    
    @Autowired
    private TrabajoEmpleadoEstadoAsyncService trabajoEmpleadoEstadoAsyncService;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            final TrabajoDto trabajo = trabajoRun.getTrabajoDto();
            final TrabajoRunDatosDto trabajoRunDatos = trabajoRun.getTrabajoRunDatos();
            if (EstadoTrabajoEnum.PENDIENTE_DATOS.getId().equals(trabajo.getEstado().getId())) {
                trabajo.setFechaInicioTrabajo(LocalDateTime.now());
                trabajo.setEstado(EstadoTrabajoDto.builder().id(EstadoTrabajoEnum.EN_CURSO_DATOS.getId()).build());
                trabajoService.modifyTrabajo(trabajo);

                CompletableFuture<Void> cfTiendasHistorico = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                        .tiendasHistorico(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfTiendasHistorico, cf, cfWait);

                if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
                	/*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfWait);
                    /*-------------------------------------------------------------*/
                    AsyncUtils.exceptionally(trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                            .tiendasEmpleadoHistorico(trabajo, trabajoRunDatos.getUno()), cf, cfWait);
                }

                CompletableFuture<Void> cfTiposHoras = trabajoDatosPtrPresenciaAsyncService.tiposHoras(trabajo);
                AsyncUtils.exceptionally(cfTiposHoras, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfWait);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfTiendasComisionable = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                        .tiendasComisionable(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfTiendasComisionable, cf);

                CompletableFuture<Void> cfEmpleados = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                        .empleadosTienda(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfEmpleados, cf);               
                
                CompletableFuture<Void> cfVentaTotalizadaTienda = trabajoDatosPtrVentaAsyncService
                        .ventaTotalizadaTienda(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfVentaTotalizadaTienda, cf);

                CompletableFuture<Void> cfPresenciaTotalizadaTienda = trabajoDatosPtrPresenciaAsyncService
                        .presenciaTotalizadaTienda(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfPresenciaTotalizadaTienda, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cfEmpleados);
                /*-------------------------------------------------------------*/

                CompletableFuture<Void> cfPresenciaDetalleEmpleado = trabajoDatosPtrPresenciaAsyncService
                        .presenciaDetalleEmpleado(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfPresenciaDetalleEmpleado, cf);

                // TODO  
//                CompletableFuture<Void> cfVentaDetalleEmpleado = trabajoDatosPtrVentaAsyncService
//                        .ventaDetalleEmpleado(trabajo, trabajoRunDatos.getUno());
//                AsyncUtils.exceptionally(cfVentaDetalleEmpleado, cf);

                CompletableFuture<Void> cfCondicionesEmpleados = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                        .condicionesEmpleados(trabajo, trabajoRunDatos.getUno());
                AsyncUtils.exceptionally(cfCondicionesEmpleados, cf);

                if (CollectionUtils.isNotEmpty(trabajo.getTiendas())
                        || CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
                    /*-------------------------------------------------------------*/
                    AsyncUtils.waitAllOfIsOk(cf, cfPresenciaDetalleEmpleado);
                    /*-------------------------------------------------------------*/
                    if (CollectionUtils.isNotEmpty(trabajoRunDatos.getUno().getTiendaPresencia())) {
                        trabajoRunDatos.getUno().getTiendaPresencia().stream().forEach(item -> {
                            if(!trabajoRunDatos.getUno().getTiendaMeta4().contains(item)) {
                                trabajoRunDatos.getDos().getTiendaPresencia().add(item);
                            }
                        });
                        
                        CompletableFuture<Void> cfTiendasPresencia = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                                .tiendasPresencia(trabajo, trabajoRunDatos.getDos());
                        AsyncUtils.exceptionally(cfTiendasPresencia, cf);

                        AsyncUtils.waitAllOfIsOk(cf, cfTiendasPresencia);

                        if (CollectionUtils.isNotEmpty(trabajoRunDatos.getDos().getTiendaMtu())) {
                            CompletableFuture<Void> cfTiendasComisionablePresencia = trabajoDatosMeta4IcmWsCalcIncomeAsyncService
                                    .tiendasComisionable(trabajo, trabajoRunDatos.getDos());
                            AsyncUtils.exceptionally(cfTiendasComisionablePresencia, cf);

                            CompletableFuture<Void> cfVentaTotalizadaTiendaPresencia = trabajoDatosPtrVentaAsyncService
                                    .ventaTotalizadaTienda(trabajo, trabajoRunDatos.getDos());
                            AsyncUtils.exceptionally(cfVentaTotalizadaTiendaPresencia, cf);

                            CompletableFuture<Void> cfPresenciaTotalizadaTiendaPresencia = trabajoDatosPtrPresenciaAsyncService
                                    .presenciaTotalizadaTienda(trabajo, trabajoRunDatos.getDos());
                            AsyncUtils.exceptionally(cfPresenciaTotalizadaTiendaPresencia, cf);
                        }
                    }
                }
                
                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                
                CompletableFuture<Void> cfPivot = trabajoPivotAsyncService.pivot(trabajo);
                AsyncUtils.exceptionally(cfPivot, cf);

                CompletableFuture<Void> cftrabajoTiendaEstado = trabajoTiendaEstadoAsyncService.save(trabajoRunDatos, trabajo);
                AsyncUtils.exceptionally(cftrabajoTiendaEstado, cf);

                CompletableFuture<Void> cftrabajoEmpleadoEstado = trabajoEmpleadoEstadoAsyncService.save(trabajoRunDatos, trabajo);
                AsyncUtils.exceptionally(cftrabajoEmpleadoEstado, cf);

                /*-------------------------------------------------------------*/
                AsyncUtils.waitAllOfIsOk(cf, cf);
                /*-------------------------------------------------------------*/
                trabajoService.modifyEstadoTrabajo(EstadoTrabajoEnum.PENDIENTE_CALCULO.getDto(), trabajo);                                                        
               
            }
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return trabajoRun;
    }

}
