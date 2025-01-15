package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.common.metrics.annotation.CounterFunctionalMetric;
import com.inditex.amigafwk.common.metrics.annotation.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarSlrhorcomsAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.AccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
  private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

  @Autowired
  private RunTareaRecolectarPtrVentaEmpleadoAsyncService runTareaRecolectarPtrVentaEmpleadoAsyncService;

  @Autowired
  private RunTareaRecolectarSlrhorcomsAsyncService runTareaRecolectarSlrhorcomsAsyncService;

  @Autowired
  private RunTareaPrevalidarDuranteService runTareaPrevalidarDuranteService;

  @Auditoria
  @TimerFunctionalMetric(metricName = "RunTareaRecolectarCondicionesService.run.timer",
      metricGroupName = "RunTareaRecolectarCondicionesServiceGroup",
      metricDescription = "RunTareaRecolectarCondicionesService.run.timer")
  @CounterFunctionalMetric(metricName = "RunTareaRecolectarCondicionesService.run.counter",
      metricGroupName = "RunTareaRecolectarCondicionesServiceGroup",
      metricDescription = "RunTareaRecolectarCondicionesService.run.counter")
  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfWait = new ArrayList<>();
    try {
      /*-----------------------------------------------------------------*/
      /*
       * Carga inicial de datos por origen, datos comunes (tienda comisionable, etc), configuraciones
       */
      /*-----------------------------------------------------------------*/

      final CompletableFuture<Void> cfAusencias = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .ausenciasByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfAusencias, cf, cfWait);

      // Tipos hora para los origenes
      final CompletableFuture<Void> cfTiposHoras = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .tiposHoraByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfTiposHoras, cf, cfWait);

      // Flag comisionable para las localizaciones del ambito
      final CompletableFuture<Void> cfTiendaComisionable = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .tiendasComisionableByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfTiendaComisionable, cf, cfWait);

      // Flag calcula para localizacion del ambito
      final CompletableFuture<Void> cfFlagCalcula = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .flagCalculaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfFlagCalcula, cf, cfWait);

      // Configuracion venta online
      final CompletableFuture<Void> cfConfiguracionVentaOnline = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .configuracionVentaOnlineByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfConfiguracionVentaOnline, cf, cfWait);

      // Desplazamiento real
      final CompletableFuture<Void> cfDesplazamientoRealByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .desplazamientoRealByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfDesplazamientoRealByRunTarea, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      final CompletableFuture<Void> cfEstadoWloc = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .estadoWlocByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEstadoWloc, cf, cfWait);

      final CompletableFuture<Void> cfConfiguracionesOrganizacion = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .configuracionesByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfConfiguracionesOrganizacion, cf, cfWait);

      // Configuracion challenge
      final CompletableFuture<Void> cfConfChallengeDiasMinimosByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .confChallengeDiasMinimosByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfConfChallengeDiasMinimosByRunTarea, cf, cfWait);

      final CompletableFuture<Void> cfConfPrecioHoraByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .confPrecioHoraByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfConfPrecioHoraByRunTarea, cf, cfWait);

      final CompletableFuture<Void> cfConfChallengeTipoVentaByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .confChallengeTipoVentaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfConfChallengeTipoVentaByRunTarea, cf, cfWait);

      // Agrupaciones de cadenas
      final CompletableFuture<Void> cfAgrupacionesCadena = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .agrupacionesCadenaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfAgrupacionesCadena, cf, cfWait);

      // Localizaciones online
      final CompletableFuture<Void> cfTiendasOnlineByRunTarea = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .localizacionesOnlineByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfTiendasOnlineByRunTarea, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      // Venta congelada
      final CompletableFuture<Void> cfVentaCongelada = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .ventaCongeladaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaCongelada, cf, cfWait);

      // Venta real ptr
      final CompletableFuture<Void> cfVentaReal = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .ventaRangoFisicaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaReal, cf, cfWait);

      final CompletableFuture<Void> cfDevolucionReal = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);
      AsyncUtils.exceptionally(cfDevolucionReal, cf, cfWait);

      final CompletableFuture<Void> cfDevolucionVentaOriginalOtraTienda = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);
      AsyncUtils.exceptionally(cfDevolucionVentaOriginalOtraTienda, cf, cfWait);

      final CompletableFuture<Void> cfVentaRangoOnlineIpodLocalizacionSeccion = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaRangoOnlineIpodLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfVentaRangoOnlineSintLocalizacionSeccion = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaRangoOnlineSintLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaRangoOnlineSintLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfVentaRangoOnlineEntregaTiendaLocalizacionSeccion =
          this.runTareaRecolectarPtrVentaEcommerceAsyncService
              .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaRangoOnlineEntregaTiendaLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfVentaRangoOnlineEntregaDomicilioLocalizacionSeccion =
          this.runTareaRecolectarPtrVentaEcommerceAsyncService
              .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaRangoOnlineEntregaDomicilioLocalizacionSeccion, cf, cfWait);

      // Tiendas de las cadenas de la agrupacion
      final CompletableFuture<Void> cfLocalizacionCadena = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .localizacionCadenaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfLocalizacionCadena, cf, cfWait);

      // Empleados de las cadenas de la agrupacion
      final CompletableFuture<Void> cfEmpleadosAgrupacion = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .empleadosCadenaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfEmpleadosAgrupacion, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      // Ventas físicas cadenas
      final CompletableFuture<Void> cfVentasFisicasByCadena = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .ventaFisicaCadenaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentasFisicasByCadena, cf, cfWait);

      // Ventas online entrega domicilio cadenas
      final CompletableFuture<Void> cfVentasEntregaDomicilioByCadena = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaOnlineEntregaDomicilioCadenaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentasEntregaDomicilioByCadena, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      // Localizacion y seccion
      final CompletableFuture<Void> cfVentaFisicaLocalizacionSeccion = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaFisicaLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlineIpodLocalizacionSeccion = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlineIpodLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlinePickingLocalizacionSeccion = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlinePickingLocalizacionSeccion, cf, cfWait);

      final CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacionSeccion = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacionSeccion, cf, cfWait);

      // Ventas individuales, tanto fisicas como iPod
      final CompletableFuture<Void> cfVentaOnlineIpodLocalizacionPersona = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .ventaOnlineIpodLocalizacionPersonaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaOnlineIpodLocalizacionPersona, cf, cfWait);

      final CompletableFuture<Void> cfVentaFisicaLocalizacionPersona = this.runTareaRecolectarPtrVentaEmpleadoAsyncService
          .ventaOnlineIpodLocalizacionPersonaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaFisicaLocalizacionPersona, cf, cfWait);

      // Presencia Persona
      final CompletableFuture<Void> cfPresenciasDetalleComisionablePersona = this.runTareaRecolectarPtrPresenciaAsyncService
          .presenciaDetalleComisionablePersonaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresenciasDetalleComisionablePersona, cf, cfWait);

      this.runTareaPrevalidarDuranteService.run(runTarea, FaseEnum.RECOLECTAR.getDto(),
          AccionEnum.PRESENCIAS.getDto());

      // Coeficiente de reduccion de jornada
      final CompletableFuture<Void> cfCoefJornada = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .coefJornadaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfCoefJornada, cf, cfWait);

      // Presencia manual
      final CompletableFuture<Void> cfPresenciaManual = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .presenciaManualByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresenciaManual, cf, cfWait);

      // Presencia manual localizacion
      final CompletableFuture<Void> cfPresenciaManualLocalizacion = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .presenciaManualLocalizacionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresenciaManualLocalizacion, cf, cfWait);

      // Venta manual localizacion
      final CompletableFuture<Void> cfVentaManualLocalizacion = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .ventaManualLocalizacionByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaManualLocalizacion, cf, cfWait);

      // Presencias incluido commerce
      final CompletableFuture<Void> cfPresenciasDetalleIncluidoCommerce = this.runTareaRecolectarPtrPresenciaAsyncService
          .presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfPresenciasDetalleIncluidoCommerce, cf, cfWait);

      // Ventas fisicas para su uso en el reparto de la venta online
      final CompletableFuture<Void> cfVentaFisicaRepartoOnline = this.runTareaRecolectarPtrVentaGeneralAsyncService
          .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfVentaFisicaRepartoOnline, cf, cfWait);

      // Politicas de los empleados de la agrupacion
      final CompletableFuture<Void> cfPoliticasAgrupacion = this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService
          .estructurasPolByConfiguracionVentaOnlineEntregaDomicilio(runTarea);
      AsyncUtils.exceptionally(cfPoliticasAgrupacion, cf, cfWait);

      // Festivos
      final CompletableFuture<Void> cfFestivos = this.runTareaRecolectarSlrhorcomsAsyncService
          .horarioComercialFestivoByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfFestivos, cf, cfWait);

      // Presencias sindicales
      final CompletableFuture<Void> cfHorasSindicales = this.runTareaRecolectarPtrPresenciaAsyncService
          .presenciaDetallePersonaHorasSindicalesByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfHorasSindicales, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cfWait);
      /*-------------------------------------------------------------*/

      // Cocinado de descartes de ventas online por configuracion
      final CompletableFuture<Void> cfUpdateActivoIpod = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .updateActivoVentaOnlineIpodByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfUpdateActivoIpod, cf, cfWait);

      final CompletableFuture<Void> cfUpdatePicking = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .updateActivoVentaOnlinePickingByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfUpdatePicking, cf, cfWait);

      final CompletableFuture<Void> cfUpdateEntregaTienda = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .updateActivoVentaOnlineEntregaTiendaByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfUpdateEntregaTienda, cf, cfWait);

      final CompletableFuture<Void> cfUpdateEntregaDomicilio = this.runTareaRecolectarPtrVentaEcommerceAsyncService
          .updateActivoVentaOnlineEntregaDomicilioByRunTarea(runTarea);
      AsyncUtils.exceptionally(cfUpdateEntregaDomicilio, cf, cfWait);

      /*-------------------------------------------------------------*/
      AsyncUtils.waitAllOfIsOk(cf, cf);
      /*-------------------------------------------------------------*/
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
