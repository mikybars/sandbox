package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;

@Service
@Validated
public class RunTareaProcesarServiceImpl implements RunTareaProcesarService {

    @Autowired
    private RunTareaProcesarVentaAsyncService runTareaProcesarVentaAsyncService;

    @Autowired
    private RunTareaProcesarPresenciaAsyncService runTareaProcesarPresenciaAsyncService;

    @Autowired
    private RunTareaProcesarCondicionesAsyncService runTareaProcesarCondicionesAsyncService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaProcesarService.run.timer",
            metricGroupName = "RunTareaProcesarServiceGroup", metricDescription = "RunTareaProcesarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaProcesarService.run.counter",
            metricGroupName = "RunTareaProcesarServiceGroup", metricDescription = "RunTareaProcesarService.run.counter")
    @Override
    public void run(@NotNull @Valid final RunTareaDto runTarea) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<CompletableFuture<?>> cfWait = new ArrayList<>();

        try {
            final CompletableFuture<Void> cfDesactivarChallengeOpcionOrigen = this.runTareaProcesarCondicionesAsyncService
                .desactivarChallengeOpcionOrigen(runTarea);
            AsyncUtils.exceptionally(cfDesactivarChallengeOpcionOrigen, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfCrearChallengeOpcionOrigen = this.runTareaProcesarCondicionesAsyncService
                .crearChallengeOpcionOrigen(runTarea);
            AsyncUtils.exceptionally(cfCrearChallengeOpcionOrigen, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Actualizar importe de estructuras minimo garantizado
            final CompletableFuture<Void> cfUpdateImporteEstructuraPoliticas = this.runTareaProcesarCondicionesAsyncService
                .updateImporteEstructuraPoliticas(runTarea);
            AsyncUtils.exceptionally(cfUpdateImporteEstructuraPoliticas, cf);

            // Actualizar flags de presencias activas
            CompletableFuture<Void> cfUpdateSeccionPresenciasActivas = this.runTareaProcesarPresenciaAsyncService
                .updateActivoLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivas, cf, cfWait);

            // TODO [JAVIEREV] Esto queda por si necesitamos arreglar rápidamente algún caso extraño con
            // presencias 0,
            // pero no debería darse nunca (y, por tanto, podríamos eliminarlo)

            // /*-------------------------------------------------------------*/
            // AsyncUtils.waitAllOfIsOk(cf, cf);
            // /*-------------------------------------------------------------*/
            //
            // //Actualizar flags de presencias totales con minutos a cero
            // CompletableFuture<Void> cfUpdatePresenciasActivasVacio = runTareaProcesarPresenciaAsyncService
            // .updateActivoLocalizacionVacio(runTarea);
            // AsyncUtils.exceptionally(cfUpdatePresenciasActivasVacio, cf);
            //
            // //Actualizar flags de presencias localizacion persona con minutos a cero
            // CompletableFuture<Void> cfUpdateSeccionPresenciasActivasVacio =
            // runTareaProcesarPresenciaAsyncService
            // .updateActivoLocalizacionPersonaPresenciaVacio(runTarea);
            // AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivasVacio, cf);

            final CompletableFuture<Void> cfTotalizarDevolucion = this.runTareaProcesarVentaAsyncService
                .totalizarDevolucionLocalizacionSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarDevolucion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarVentaSinDevolucion = this.runTareaProcesarVentaAsyncService
                .totalizarVentaSinDevolucionLocalizacionSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaSinDevolucion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarVentaPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarVentaPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarVentaSinDevolucionPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarVentaSinDevolucionPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaSinDevolucionPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarVentaFisicaSinDevolucionPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarVentaFisicaSinDevolucionPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaFisicaSinDevolucionPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarVentaOnlineIpodSinDevolucionPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaOnlineIpodSinDevolucionPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarDevolucionFisicaPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarDevolucionFisicaPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarDevolucionFisicaPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarDevolucionOnlineIpodPersonaSeccion = this.runTareaProcesarVentaAsyncService
                .totalizarDevolucionOnlineIpodPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarDevolucionOnlineIpodPersonaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarDevolucionPersona = this.runTareaProcesarVentaAsyncService
                .totalizarDevolucionPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarDevolucionPersona, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Activar estructuras topes
            // final CompletableFuture<Void> cfActivoTopes = this.runTareaProcesarCondicionesAsyncService
            // .updateActivoEstructurasTopes(runTarea.getTarea());
            // AsyncUtils.exceptionally(cfActivoTopes, cf, cfWait);

            // Calcular localizacion abierta
            final CompletableFuture<Void> cfSaveAbierto = this.runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
            AsyncUtils.exceptionally(cfSaveAbierto, cf, cfWait);

            // Calcular localizacion seccion abierta
            final CompletableFuture<Void> cfSaveAbiertoSeccion = this.runTareaProcesarVentaAsyncService
                .saveAbiertoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveAbiertoSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Calcular localizacion cerrada
            final CompletableFuture<Void> cfSaveCerrado = this.runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
            AsyncUtils.exceptionally(cfSaveCerrado, cf, cfWait);

            // Calcular localizacion seccion cerrada
            final CompletableFuture<Void> cfSaveCerradoSeccion = this.runTareaProcesarVentaAsyncService
                .saveCerradoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveCerradoSeccion, cf, cfWait);


            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Generar presencias horas fijas en desplazamientos
            final CompletableFuture<Void> cfPresenciasHorasFijasDesplazamientos = this.runTareaProcesarPresenciaAsyncService
                .presenciasHorasFijasDesplazamientos(runTarea);
            AsyncUtils.exceptionally(cfPresenciasHorasFijasDesplazamientos, cf, cfWait);

            // Generar presencias horas fijas en la localizacion de la persona
            final CompletableFuture<Void> cfPresenciasHorasFijas = this.runTareaProcesarPresenciaAsyncService
                .presenciasHorasFijas(runTarea);
            AsyncUtils.exceptionally(cfPresenciasHorasFijas, cf, cfWait);


            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Actualizar flags de presencias activas
            cfUpdateSeccionPresenciasActivas = this.runTareaProcesarPresenciaAsyncService
                .updateActivoLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivas, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Totalizamos las presencias de la tienda por seccion
            final CompletableFuture<Void> cfTotalizarPresenciaLocalizacion = this.runTareaProcesarPresenciaAsyncService
                .totalizarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaLocalizacion, cf, cfWait);

            // Compensar presencia total localizacion persona con las manuales
            final CompletableFuture<Void> cfCompensarPresenciaPersonaLocalizacion = this.runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaPersonaLocalizacion, cf, cfWait);

            // Compensar presencia total incluido challenge
            final CompletableFuture<Void> cfCompensarChallenge = this.runTareaProcesarPresenciaAsyncService
                .compensarChallenge(runTarea);
            AsyncUtils.exceptionally(cfCompensarChallenge, cf, cfWait);

            // Compensar presencia total localizacion con las manuales para incluido ecommerce
            final CompletableFuture<Void> cfCompensarPresenciaLocalizacionEcommerce = this.runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionEcommerce(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacionEcommerce, cf, cfWait);

            final CompletableFuture<Void> cfTotalizarPresenciaEcommerceLocalizacion = this.runTareaProcesarPresenciaAsyncService
                .totalizarEcommerceLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaEcommerceLocalizacion, cf, cfWait);

            // Empleados por venta
            final CompletableFuture<Void> cfTotalizarEmpleadosPorVenta = this.runTareaProcesarPresenciaAsyncService
                .totalizarEmpleadosPorVenta(runTarea);
            AsyncUtils.exceptionally(cfTotalizarEmpleadosPorVenta, cf, cfWait);

            // Obtener la presencia incluido venta por empleado
            final CompletableFuture<Void> cfPresenciasIncluidoVentaPersona = this.runTareaProcesarPresenciaAsyncService
                .presenciasIncluidoVentaPersona(runTarea);
            AsyncUtils.exceptionally(cfPresenciasIncluidoVentaPersona, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Compenar presencia total localizacion con las manuales de tienda
            final CompletableFuture<Void> cfCompensarPresenciaLocalizacionManual = this.runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionManual(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacionManual, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Indicadores de presencia
            final CompletableFuture<Void> cfIndicadorPresencia = this.runTareaProcesarPresenciaAsyncService
                .indicadorPresencia(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresencia, cf, cfWait);

            // Indicadores de presencia con desplazamiento
            final CompletableFuture<Void> cfIndicadorPresenciaDesplazamiento = this.runTareaProcesarPresenciaAsyncService
                .indicadorPresenciaDesplazamiento(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamiento, cf, cfWait);

            // Indicadores de presencia con desplazamiento base
            final CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBase = this.runTareaProcesarPresenciaAsyncService
                .indicadorPresenciaDesplazamientoBase(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBase, cf, cfWait);

            // Indicadores de presencia con desplazamiento base sobre desplazamiento misma localizacion
            final CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion = this.runTareaProcesarPresenciaAsyncService
                .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion, cf, cfWait);

            // Indicadores de presencia de por venta simplificada y por venta
            final CompletableFuture<Void> cfIndicadorPersonasPorVentaSimplificada = this.runTareaProcesarPresenciaAsyncService
                .indicadorPersonaPorVentaSimplificada(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPersonasPorVentaSimplificada, cf, cfWait);

            final CompletableFuture<Void> cfIndicadorPersonasPorVenta = this.runTareaProcesarPresenciaAsyncService
                .indicadorPersonaPorVenta(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPersonasPorVenta, cf, cfWait);

            // Indicadores directo venta e importe tienda
            final CompletableFuture<Void> cfIndicadorDesplazamientoDirectoVenta = this.runTareaProcesarPresenciaAsyncService
                .indicadorDesplazamientoDirectoVenta(runTarea);
            AsyncUtils.exceptionally(cfIndicadorDesplazamientoDirectoVenta, cf, cfWait);

            final CompletableFuture<Void> cfIndicadorDesplazamientoDirectoVentaFicticias = this.runTareaProcesarPresenciaAsyncService
                .indicadorDesplazamientoDirectoVentaFicticias(runTarea);
            AsyncUtils.exceptionally(cfIndicadorDesplazamientoDirectoVentaFicticias, cf, cfWait);

            final CompletableFuture<Void> cfIndicadorDesplazamientoBaseDirectoVenta = this.runTareaProcesarPresenciaAsyncService
                .indicadorDesplazamientoBaseDirectoVenta(runTarea);
            AsyncUtils.exceptionally(cfIndicadorDesplazamientoBaseDirectoVenta, cf, cfWait);

            final CompletableFuture<Void> cfIndicadorDesplazamientoBaseDirectoVentaFicticias = this.runTareaProcesarPresenciaAsyncService
                .indicadorDesplazamientoBaseDirectoVentaFicticias(runTarea);
            AsyncUtils.exceptionally(cfIndicadorDesplazamientoBaseDirectoVentaFicticias, cf, cfWait);

            // Presencias totales de agrupaciones
            final CompletableFuture<Void> cfCalcularPresenciasTotalesAgrupacion = this.runTareaProcesarPresenciaAsyncService
                .calcularPresenciasTotalesAgrupacion(runTarea);
            AsyncUtils.exceptionally(cfCalcularPresenciasTotalesAgrupacion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Calcular ventas localizacion realizadas por personas por venta simplificado
            final CompletableFuture<Void> cfVentasPorVentaSimplificado = this.runTareaProcesarVentaAsyncService
                .totalizarVentaPersonasPorVentaSimplificada(runTarea);
            AsyncUtils.exceptionally(cfVentasPorVentaSimplificado, cf, cfWait);

            // Calcular ventas localizacion realizadas por personas por venta
            final CompletableFuture<Void> cfVentasPorVenta = this.runTareaProcesarVentaAsyncService
                .totalizarVentaSinDevolucionPersonasPorVenta(runTarea);
            AsyncUtils.exceptionally(cfVentasPorVenta, cf, cfWait);

            // Calcular ventas localizacion realizadas por vendedor 0 (personas no venta)
            final CompletableFuture<Void> cfVentasVendedor0 = this.runTareaProcesarVentaAsyncService
                .totalizarVentasVendedor0(runTarea);
            AsyncUtils.exceptionally(cfVentasVendedor0, cf, cfWait);

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por ventas
            final CompletableFuture<Void> cfRepartoAgrupaciones = this.runTareaProcesarVentaAsyncService
                .repartoVentaEntregaDomicilioAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoAgrupaciones, cf, cfWait);

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por presencia
            final CompletableFuture<Void> cfRepartoPresenciaAgrupaciones = this.runTareaProcesarVentaAsyncService
                .repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoPresenciaAgrupaciones, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Reparto devoluciones vendedor 0 entre el numero de vendedores de la tienda
            final CompletableFuture<Void> cfRepartoVendedor0 = this.runTareaProcesarVentaAsyncService
                .repartoDevolucionVendedor0(runTarea);
            AsyncUtils.exceptionally(cfRepartoVendedor0, cf, cfWait);

            // Calcular importe comision vendedores por venta
            final CompletableFuture<Void> cfCalcularImporteComisionVendedores = this.runTareaProcesarVentaAsyncService
                .calcularImporteComisionVendedores(runTarea);
            AsyncUtils.exceptionally(cfCalcularImporteComisionVendedores, cf, cfWait);

            // Reparto de ventas online entrega domicilio por sección
            final CompletableFuture<Void> cfRepartoVentaOnlineEntregaDomicilioSeccion = this.runTareaProcesarVentaAsyncService
                .repartoVentaEntregaDomicilioSeccion(runTarea);
            AsyncUtils.exceptionally(cfRepartoVentaOnlineEntregaDomicilioSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfTrasladar = this.runTareaProcesarVentaAsyncService.trasladar(runTarea);
            AsyncUtils.exceptionally(cfTrasladar, cf, cfWait);

            final CompletableFuture<Void> cfCompensar = this.runTareaProcesarVentaAsyncService.compensar(runTarea);
            AsyncUtils.exceptionally(cfCompensar, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfCompensarOnlineSeccionCerrada = this.runTareaProcesarVentaAsyncService
                .compensarOnlineSeccionCerrada(runTarea);
            AsyncUtils.exceptionally(cfCompensarOnlineSeccionCerrada, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoTrasladadasSeccion = this.runTareaProcesarVentaAsyncService
                .updateActivoTrasladadasSeccion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfAgruparOnlineSeccionDia = this.runTareaProcesarVentaAsyncService
                .agruparOnlineSeccionDia(runTarea);
            AsyncUtils.exceptionally(cfAgruparOnlineSeccionDia, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoTrasladadasTotalizado = this.runTareaProcesarVentaAsyncService
                .updateActivoTrasladadasTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasTotalizado, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfCalcularImporteComisionVentaODevolucion = this.runTareaProcesarVentaAsyncService
                .calcularImporteComisionVentaODevolucion(runTarea);
            AsyncUtils.exceptionally(cfCalcularImporteComisionVentaODevolucion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoNegativoTotalizado = this.runTareaProcesarVentaAsyncService
                .updateActivoNegativoTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoNegativoTotalizado, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfTotalizarPresupuesto = this.runTareaProcesarVentaAsyncService
                .totalizarPresupuesto(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresupuesto, cf, cfWait);
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoPresupuesto = this.runTareaProcesarVentaAsyncService
                .updateActivoExcepcionada(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoPresupuesto, cf, cfWait);
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoCongeladaSeccion = this.runTareaProcesarVentaAsyncService
                .updateActivoCongeladaSeccion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoCongeladaSeccion, cf, cfWait);

            final CompletableFuture<Void> cfUpdateActivoCongelada = this.runTareaProcesarVentaAsyncService
                .updateActivoCongelada(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoCongelada, cf, cfWait);

            final CompletableFuture<Void> cfUpdateActivoPresupuestoBandaExcepcion = this.runTareaProcesarCondicionesAsyncService
                .updateActivoPresupuestosBandaExcepcion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoPresupuestoBandaExcepcion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfUpdateActivoPresupuestoBandasSinExcepcion = this.runTareaProcesarCondicionesAsyncService
                .updateActivoPresupuestosBandasSinExcepcion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoPresupuestoBandasSinExcepcion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            final CompletableFuture<Void> cfRelacionarPresupuestosEstructurasSinDesplazamiento = this.runTareaProcesarCondicionesAsyncService
                .relacionarPresupuestosEstructurasSinDesplazamiento(runTarea.getTarea());
            AsyncUtils.exceptionally(cfRelacionarPresupuestosEstructurasSinDesplazamiento, cf, cfWait);

            final CompletableFuture<Void> cfRelacionarPresupuestosEstructurasDesplazamiento = this.runTareaProcesarCondicionesAsyncService
                .relacionarPresupuestosEstructurasDesplazamiento(runTarea.getTarea());
            AsyncUtils.exceptionally(cfRelacionarPresupuestosEstructurasDesplazamiento, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
