package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarSlrhorcomsAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaRecolectarCondicionesServiceImplTest {

  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Mock
  private RunTareaRecolectarPtrVentaGeneralAsyncService runTareaRecolectarPtrVentaGeneralAsyncService;

  @Mock
  private RunTareaRecolectarPtrVentaEcommerceAsyncService runTareaRecolectarPtrVentaEcommerceAsyncService;

  @Mock
  private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;

  @Mock
  private RunTareaRecolectarPtrVentaEmpleadoAsyncService runTareaRecolectarPtrVentaEmpleadoAsyncService;

  @Mock
  private RunTareaRecolectarSlrhorcomsAsyncService runTareaRecolectarSlrhorcomsAsyncService;

  @Mock
  private RunTareaPrevalidarDuranteService runTareaPrevalidarDuranteService;

  @Spy
  @InjectMocks
  private RunTareaRecolectarCondicionesServiceImpl RunTareaRecolectarCondicionesServiceImpl;

  RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @ParameterizedTest
  @InstancioSource
  void runTest(final CompletableFuture<Void> completableFuture) {

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .ausenciasByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .tiposHoraByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .tiendasComisionableByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .flagCalculaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .configuracionVentaOnlineByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .desplazamientoRealByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .estadoWlocByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .configuracionesByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .confChallengeDiasMinimosByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .confPrecioHoraByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .confPrecioHoraByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .confChallengeTipoVentaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .agrupacionesCadenaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .localizacionesOnlineByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .ventaCongeladaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .ventaRangoFisicaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaRangoOnlineSintLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .localizacionCadenaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .empleadosCadenaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .ventaFisicaCadenaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaOnlineEntregaDomicilioCadenaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaOnlinePickingLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .ventaOnlineIpodLocalizacionPersonaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEmpleadoAsyncService)
        .ventaOnlineIpodLocalizacionPersonaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrPresenciaAsyncService)
        .presenciaDetalleComisionablePersonaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .coefJornadaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .presenciaManualByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .presenciaManualLocalizacionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .ventaManualLocalizacionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrPresenciaAsyncService)
        .presenciaDetallePersonaIncluidoCommerceByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaGeneralAsyncService)
        .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .estructurasPolByConfiguracionVentaOnlineEntregaDomicilio(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarSlrhorcomsAsyncService)
        .horarioComercialFestivoByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrPresenciaAsyncService)
        .presenciaDetallePersonaHorasSindicalesByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .updateActivoVentaOnlineIpodByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .updateActivoVentaOnlinePickingByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .updateActivoVentaOnlineEntregaTiendaByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.runTareaRecolectarPtrVentaEcommerceAsyncService)
        .updateActivoVentaOnlineEntregaDomicilioByRunTarea(this.runTarea);

    this.RunTareaRecolectarCondicionesServiceImpl.run(this.runTarea);

    verify(this.RunTareaRecolectarCondicionesServiceImpl, times(1))
        .run(this.runTarea);
  }

  @Test
  void runExceptionTest() {

    doThrow(new RuntimeException()).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .ausenciasByRunTarea(this.runTarea);

    assertThrows(RuntimeException.class, () -> {
      this.RunTareaRecolectarCondicionesServiceImpl.run(this.runTarea);
    });
  }

}
