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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaSeccionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarCondicionesServiceImpl implements RunTareaRecolectarCondicionesService {

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralAsyncService runTareaRecolectarPtrVentaGeneralAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaEcommerceAsyncService runTareaRecolectarPtrVentaEcommerceAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaEmpleadoAsyncService runTareaRecolectarPtrVentaEmpleadoAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
    
    @Autowired
    private TareaLocalizacionPersonaSeccionPresenciaAsyncService tareaLocalizacionPersonaSeccionPresenciaAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            // Estructuras
            CompletableFuture<Void> cfCondicionPersona = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .condicionPersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfCondicionPersona, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            // TODO Por cada recuperacion hay que detectar para que localizaciones o
            // personas es necesario recuperar el dato

            // Localizacion y seccion
            CompletableFuture<Void> cfVentaFisicaLocalizacionSeccion = runTareaRecolectarPtrVentaGeneralAsyncService
                    .ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentaFisicaLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfOnlineIpodLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfOnlinePickingLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlinePickingLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfOnlineEntregaDomicilioLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaDomicilioLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfPresenciasTotalLocalizacionSeccion = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaTotalLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasTotalLocalizacionSeccion, cf, cfWait);

            // Localizacion

            CompletableFuture<Void> cfVentaFisicaLocalizacion = runTareaRecolectarPtrVentaGeneralAsyncService
                    .ventaFisicaLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentaFisicaLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlineIpodLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlinePickingLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlinePickingLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlinePickingLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineEntregaTiendaLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlineEntregaDomicilioLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineEntregaDomicilioLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaDomicilioLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfFisicaDetalleLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService
                    .ventaFisicaDetalleLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaDetalleLocalizacion, cf, cfWait);

            // Operacion localizacion

            CompletableFuture<Void> cfFisicaDetalleOperacionLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService
                    .ventaFisicaDetalleOperacionLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaDetalleOperacionLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlineIpodDetalleOperacionLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodDetalleOperacionLocalizacion, cf, cfWait);

            // Operacion vendedor localizacion

            CompletableFuture<Void> cfFisicaDetalleOperacionVendedorLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService
                    .ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaDetalleOperacionVendedorLocalizacion, cf, cfWait);

            // Vendedor localizacion

            CompletableFuture<Void> cfFisicaDetalleVendedorLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService
                    .ventaFisicaDetalleVendedorLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaDetalleVendedorLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfOnlineIpodDetalleVendedorLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodDetalleVendedorLocalizacion, cf, cfWait);

            // Persona
            CompletableFuture<Void> cfPresenciasDetalleComisionablePersona = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaDetalleComisionablePersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasDetalleComisionablePersona, cf, cfWait);

            // Localizacion Persona
            CompletableFuture<Void> cfOnlineIpodDetalle = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodDetalleLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodDetalle, cf, cfWait);

            // Tienda comisionable
            CompletableFuture<Void> cfTiendaComisionable = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .tiendasComisionableByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiendaComisionable, cf, cfWait);

            // Tipos hora
            CompletableFuture<Void> cfTiposHoras = runTareaRecolectarPtrPresenciaAsyncService
                    .tiposHorasByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiposHoras, cf, cfWait);

            // Periodos
            CompletableFuture<Void> cfPeriodos = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .periodosByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPeriodos, cf, cfWait);
            
            // Coeficiente de reduccion de jornada
            CompletableFuture<Void> cfCoefJornada = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .coefJornadaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfCoefJornada, cf, cfWait);
            
            // Flag calcula de localizacion
            CompletableFuture<Void> cfFlagCalcula = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .flagCalculaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFlagCalcula, cf, cfWait);

            // Presencia manual
            CompletableFuture<Void> cfPresenciaManual = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .presenciaManualByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciaManual, cf, cfWait);
            
            // Festivos
            CompletableFuture<Void> cfFestivos = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .festivosByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFestivos, cf, cfWait);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            // Marcado de presencias manuales como activas
            CompletableFuture<Void> cfUpdateActivo = tareaLocalizacionPersonaSeccionPresenciaAsyncService
                    .updateActivo(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivo, cf, cfWait);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
