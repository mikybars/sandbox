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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarCondicionesServiceImpl implements RunTareaRecolectarCondicionesService {

    @Autowired
    private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralAsyncService runTareaRecolectarPtrVentaGeneralAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaEcommerceAsyncService runTareaRecolectarPtrVentaEcommerceAsyncService;

    @Autowired
    private RunTareaRecolectarPtrVentaEmpleadoAsyncService runTareaRecolectarPtrVentaEmpleadoAsyncService;

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
            /*-----------------------------------------------------------------*/
            /*
             * Carga inicial de estructuras, datos por origen, datos comunes (tienda
             * comisionable, etc), configuraciones
             */
            /*-----------------------------------------------------------------*/
            // Estructuras (Tramado estructuras (ApV)  Detalle comision (Meta4))
            CompletableFuture<Void> cfCondicionPersona = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .condicionPersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfCondicionPersona, cf, cfWait);

            // Tipos hora para los origenes
            CompletableFuture<Void> cfTiposHoras = runTareaRecolectarPtrPresenciaAsyncService
                    .tiposHorasByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiposHoras, cf);

            // Flag comisionable para las localizaciones del ambito
            CompletableFuture<Void> cfTiendaComisionable = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .tiendasComisionableByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiendaComisionable, cf);

            // Flag calcula para localizacion del ambito
            CompletableFuture<Void> cfFlagCalcula = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .flagCalculaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFlagCalcula, cf);

            // Configuracion venta online
            CompletableFuture<Void> cfConfiguracionVentaOnline = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .configuracionVentaOnlineByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfConfiguracionVentaOnline, cf, cfWait);

            // Agrupaciones de cadenas
            CompletableFuture<Void> cfAgrupacionesCadena = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .agrupacionesCadenaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfAgrupacionesCadena, cf, cfWait);

            // Localizaciones online
            CompletableFuture<Void> cfTiendasOnlineByRunTarea = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                .localizacionesOnlineByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfTiendasOnlineByRunTarea, cf, cfWait);

            // Presencias cadenas
            CompletableFuture<Void> cfPresenciasCadena = runTareaRecolectarPtrPresenciaAsyncService
                .presenciaTotalCadenaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasCadena, cf, cfWait);

            // Ventas físicas cadenas
            CompletableFuture<Void> cfVentasFisicasByCadena = runTareaRecolectarPtrVentaGeneralAsyncService
                .ventaFisicaCadenaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentasFisicasByCadena, cf, cfWait);

            // Ventas online entrega domicilio cadenas
            CompletableFuture<Void> cfVentasEntregaDomicilioByCadena = runTareaRecolectarPtrVentaEcommerceAsyncService
                .ventaOnlineEntregaDomicilioCadenaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentasEntregaDomicilioByCadena, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

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

            CompletableFuture<Void> cfOnlineIpodDetalle = runTareaRecolectarPtrVentaEcommerceAsyncService
                    .ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodDetalle, cf, cfWait);

            CompletableFuture<Void> cfPresenciasTotalLocalizacionSeccion = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaTotalLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasTotalLocalizacionSeccion, cf, cfWait);

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

            CompletableFuture<Void> cfPresenciasDetalleComisionableLocalizacionPersona = runTareaRecolectarPtrPresenciaAsyncService
                    .presenciaDetalleComisionableLocalizacionPersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasDetalleComisionableLocalizacionPersona, cf, cfWait);

            // Coeficiente de reduccion de jornada
            CompletableFuture<Void> cfCoefJornada = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .coefJornadaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfCoefJornada, cf, cfWait);

            // Presencia manual
            CompletableFuture<Void> cfPresenciaManual = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
                    .presenciaManualByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciaManual, cf, cfWait);

            // Festivos
//            CompletableFuture<Void> cfFestivos = runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
//                    .festivosByRunTarea(runTarea);
//            AsyncUtils.exceptionally(cfFestivos, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Cocinado de descartes de ventas online por configuracion
            CompletableFuture<Void> cfUpdateActivoIpod = runTareaRecolectarPtrVentaEcommerceAsyncService
                .updateActivoVentaOnlineIpodByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoIpod, cfWait);

            CompletableFuture<Void> cfUpdatePicking = runTareaRecolectarPtrVentaEcommerceAsyncService
                .updateActivoVentaOnlinePickingByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfUpdatePicking, cfWait);

            CompletableFuture<Void> cfUpdateEntregaTienda = runTareaRecolectarPtrVentaEcommerceAsyncService
                .updateActivoVentaOnlineEntregaTiendaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfUpdateEntregaTienda, cfWait);

            CompletableFuture<Void> cfUpdateEntregaDomicilio = runTareaRecolectarPtrVentaEcommerceAsyncService
                .updateActivoVentaOnlineEntregaDomicilioByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfUpdateEntregaDomicilio, cfWait);

            // También de presencias
            CompletableFuture<Void> cfUpdatePresenciaCadenas = runTareaRecolectarPtrPresenciaAsyncService
                .updateActivoCadenaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfUpdatePresenciaCadenas, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
