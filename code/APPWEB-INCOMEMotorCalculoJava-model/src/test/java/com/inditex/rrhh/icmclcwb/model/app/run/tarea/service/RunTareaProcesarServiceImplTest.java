package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaProcesarServiceImplTest {

  @Mock
  private RunTareaProcesarVentaAsyncService runTareaProcesarVentaAsyncService;

  @Mock
  private RunTareaProcesarPresenciaAsyncService runTareaProcesarPresenciaAsyncService;

  @Mock
  private RunTareaProcesarCondicionesAsyncService runTareaProcesarCondicionesAsyncService;

  @Mock
  private TareaFaseService tareaFaseService;

  @Spy
  @InjectMocks
  private RunTareaProcesarServiceImpl runTareaProcesarServiceImpl;

  final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @ParameterizedTest
  @InstancioSource
  void runTest(final TareaFaseDto tareaFaseDto,
      final CompletableFuture<Void> completableFuture) {

    doReturn(tareaFaseDto).when(this.tareaFaseService).findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTarea().getId(),
        FaseEnum.PROCESAR.getId());

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .desactivarChallengeOpcionOrigen(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarPresenciasSindicalesLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarEcommerceSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .desactivarManualOrdinalDoble(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .crearChallengeOpcionOrigen(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .crearGlobalSeccionOpcionOrigen(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .desactivarGlobalSeccionOpcionOrigen(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .igualarBandasOrigenDestino(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .establecerBandaOpcionOrigen(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .updateImporteEstructuraPoliticas(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .updateActivoLocalizacionPersonaPresencia(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionLocalizacionSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarVentaSinDevolucionLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarVentaSinDevolucionPersonaLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionPersonaLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarVentaFisicaSinDevolucionPersonaSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .saveAbierto(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionOnlineIpodPersonaSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionFisicaPersonaSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .saveAbiertoSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .saveCerrado(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .saveCerradoSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .presenciasHorasFijasDesplazamientos(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .presenciasHorasFijas(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .updateActivoLocalizacionPersonaPresencia(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .repartirPresenciasSindicalesLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .repartirPresenciasSindicalesLocalizacionSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarLocalizacionIncluidoChallengePorcentaje(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .compensarLocalizacionPersonaPresencia(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .compensarChallenge(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarEcommerceLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .totalizarEmpleadosPorVenta(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .presenciasIncluidoVentaPersona(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .compensarLocalizacionManual(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .compensarLocalizacionIncluidoChallengePorcentaje(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorPresencia(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorPresenciaDesplazamiento(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorPresenciaDesplazamientoBase(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .presenciaDesplazamiento(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .presenciaDesplazamientoChallengePorcentaje(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorPersonaPorVenta(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoDirectoVenta(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoDirectoVentaSinPresencias(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoBaseDirectoVenta(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoBaseDirectoVentaOtraTienda(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoDirectoVentaCambioFuncion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .indicadorDesplazamientoChallengeImporteTienda(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarPresenciaAsyncService)
        .calcularPresenciasTotalesAgrupacion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarVentaSinDevolucionPersonasPorVenta(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarDevolucionesVendedor0(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .repartoVentaEntregaDomicilioPorVentasAgrupaciones(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .repartoDevolucionVendedor0(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .calcularImporteComisionVendedores(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .repartoVentaEntregaDomicilioSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .trasladar(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .compensar(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .compensarOnlineSeccionCerrada(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoTrasladadasSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .agruparOnlineSeccionDia(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoTrasladadasTotalizado(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .calcularImporteComisionVentaODevolucion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .devolucionImporte0(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoNegativoTotalizado(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .totalizarPresupuesto(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoExcepcionada(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoCongeladaSeccion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoCongelada(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .updateActivoPresupuestosBandaExcepcion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .updateActivoPresupuestosBandasSinExcepcion(this.runTarea);

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .relacionarPresupuestosEstructurasSinDesplazamiento(this.runTarea.getTarea());

    doReturn(completableFuture).when(this.runTareaProcesarCondicionesAsyncService)
        .relacionarPresupuestosEstructurasDesplazamiento(this.runTarea.getTarea());

    doReturn(completableFuture).when(this.runTareaProcesarVentaAsyncService)
        .updateActivoManual(this.runTarea);

    doReturn(tareaFaseDto).when(this.tareaFaseService)
        .findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTarea().getId(), FaseEnum.PROCESAR.getId());

    doReturn(tareaFaseDto).when(this.tareaFaseService)
        .findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTarea().getId(), FaseEnum.PROCESAR.getId());

    this.runTareaProcesarServiceImpl.run(this.runTarea);

    verify(this.runTareaProcesarServiceImpl, times(1))
        .run(this.runTarea);
  }

  @ParameterizedTest
  @InstancioSource
  void runExceptionTest(final TareaFaseDto tareaFaseDto,
      final CompletableFuture<Void> completableFuture) {

    doThrow(RuntimeException.class).when(this.tareaFaseService).findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTarea().getId(),
        FaseEnum.PROCESAR.getId());

    doReturn(tareaFaseDto).when(this.tareaFaseService)
        .findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTarea().getId(), FaseEnum.PROCESAR.getId());

    assertThrows(RuntimeException.class, () -> {
      this.runTareaProcesarServiceImpl.run(this.runTarea);
    });
  }

}
