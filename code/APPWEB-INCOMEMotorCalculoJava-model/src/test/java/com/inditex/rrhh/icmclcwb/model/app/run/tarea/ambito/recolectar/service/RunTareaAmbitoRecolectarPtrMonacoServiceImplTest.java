package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoRecolectarPtrMonacoServiceImplTest {

  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Mock
  private PtrVentaGeneralAsyncService ptrVentaGeneralAsyncService;

  @Mock
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Mock
  private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  @Mock
  private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  @Mock
  private Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Mock
  private RecolectarPropertiesDto recolectarProperties;

  @Mock
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Mock
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @Mock
  private RunTareaAmbitoRecolectarPtrMonacoService runTareaAmbitoRecolectarPtrMonacoService;

  @Mock
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Spy
  @InjectMocks
  private RunTareaAmbitoRecolectarPtrMonacoServiceImpl ventasMonacoService;

  @Random
  private RunTareaDto runTarea;

  @Random
  private RunTareaDto runTarea2;

  @Random
  private TareaAmbitoDto ambito;

  @BeforeAll
  void setup() {
    this.runTarea.getTarea().setAmbito(Arrays.asList(this.ambito));
    this.runTarea.getTrabajo().getTipoAmbito().setId(4L);
    this.runTarea2.getTarea().setAmbito(Arrays.asList(this.ambito));
  }

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaTest(@Random final PeriodoDto periodo,
      @Random(size = 1, type = IdLocalizacionLocalDto.class) final List<IdLocalizacionLocalDto> idLocList,
      @Random final PtrVentaTotalizadoRequestDto request,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoList,
      @Random final PtrVentaTotalizadoResponseDto ventaTotalizadoresponse) {

    idLocList.get(0).setId("1");

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");

    doReturn(periodo).when(this.tareaLocalizacionPresupuestoService).findPeriodoPresupuestoYTrabajo(this.runTarea.getTarea().getId());

    doReturn(idLocList).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
            this.ambito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));
    doReturn(propertiesDto).when(this.ventaGeneralProperties).get(PtrPropertiesConstants.VENTA_TOTALIZADO);

    doReturn(request).when(this.tareaMapper)
        .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaTotalizadoRequestDto(this.runTarea.getTarea(), this.ambito, periodo,
            this.recolectarProperties);

    doReturn(confProductoList).when(this.meta4IcmWsCalcIncomeSessionService)
        .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen());

    final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = CompletableFuture.completedFuture(ventaTotalizadoresponse);
    doReturn(cfData).when(this.ptrVentaGeneralAsyncService).ventaTotalizado(any(PtrVentaTotalizadoRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionVentaAsyncService)
        .savePtrVentaTotalizadoResponse(ventaTotalizadoresponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);

    verify(this.ventasMonacoService, times(1))
        .ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaExceptionTest() {
    doThrow(new RuntimeException()).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea2.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.IPOD.getId());
    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest(
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1, type = IdLocalizacionLocalDto.class) final List<IdLocalizacionLocalDto> idLocList,
      @Random(size = 1, type = PeriodoDto.class) final List<PeriodoDto> periodos,
      @Random final PtrVentaOnlineIpodRequestDto paramVentaOnlineIpod,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoResult,
      @Random final PtrVentaOnlineIpodResponseDto ventaOnlineIpodResponse) {

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");

    doReturn(propertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_IPOD);

    cadenas.get(0).setId("1");
    doReturn(cadenas).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.IPOD.getId());

    idLocList.get(0).setId("1");
    doReturn(idLocList).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
            this.ambito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));

    doReturn(periodos).when(this.tareaLocalizacionPresupuestoService)
        .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

    doReturn(paramVentaOnlineIpod).when(this.tareaMapper).mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineIpodRequestDto(
        this.runTarea.getTarea(), this.ambito, periodos.get(0));

    confProductoResult.get(0).setIdProducto(1);
    doReturn(confProductoResult).when(this.meta4IcmWsCalcIncomeSessionService)
        .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen());

    final CompletableFuture<PtrVentaOnlineIpodResponseDto> cfData = CompletableFuture.completedFuture(ventaOnlineIpodResponse);
    doReturn(cfData).when(this.ptrVentaEcommerceAsyncService).ventaOnlineiPod(any(PtrVentaOnlineIpodRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionVentaAsyncService)
        .savePtrVentaOnlineIpodResponse(ventaOnlineIpodResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea2.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.IPOD.getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest(
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1, type = IdLocalizacionLocalDto.class) final List<IdLocalizacionLocalDto> idLocList,
      @Random(size = 1, type = PeriodoDto.class) final List<PeriodoDto> periodos,
      @Random final PtrVentaOnlinePickingRequestDto paramVentaOnlinePicking,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResult,
      @Random final PtrVentaOnlinePickingResponseDto ventaOnlinePickingResponse) {

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");

    doReturn(propertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);

    cadenas.get(0).setId("1");
    doReturn(cadenas).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.SINT.getId());

    idLocList.get(0).setId("1");
    doReturn(idLocList).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
            this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));

    doReturn(periodos).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
        this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

    doReturn(paramVentaOnlinePicking).when(this.tareaMapper).mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(
        this.runTarea.getTarea(), this.ambito, periodos.get(0));

    confProductoVentaResult.get(0).setIdProducto(1);
    doReturn(confProductoVentaResult).when(this.meta4IcmWsCalcIncomeSessionService)
        .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen());

    final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData = CompletableFuture.completedFuture(ventaOnlinePickingResponse);
    doReturn(cfData).when(this.ptrVentaEcommerceAsyncService).ventaOnlinePicking(any(PtrVentaOnlinePickingRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionVentaAsyncService)
        .savePtrVentaOnlinePickingResponse(ventaOnlinePickingResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest(
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1, type = IdLocalizacionLocalDto.class) final List<IdLocalizacionLocalDto> idLocList,
      @Random(size = 1, type = PeriodoDto.class) final List<PeriodoDto> periodos,
      @Random final PtrVentaOnlineEntregaTiendaRequestDto paramVentaOnlineEntregaTienda,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResult,
      @Random final PtrVentaOnlineEntregaTiendaResponseDto ptrVentaOnlineEntregaTiendaResponse) {

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");

    doReturn(propertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA);

    cadenas.get(0).setId("1");
    doReturn(cadenas).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.ENTREGA_TIENDA.getId());

    idLocList.get(0).setId("1");
    doReturn(idLocList).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
            this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(), Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));

    doReturn(periodos).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
        this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

    doReturn(paramVentaOnlineEntregaTienda).when(this.tareaMapper)
        .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrVentaOnlineEntregaTiendaRequestDto(
            this.runTarea.getTarea(), this.ambito, periodos.get(0));

    doReturn(confProductoVentaResult).when(this.meta4IcmWsCalcIncomeSessionService)
        .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen());

    final CompletableFuture<PtrVentaOnlineEntregaTiendaResponseDto> cfData =
        CompletableFuture.completedFuture(ptrVentaOnlineEntregaTiendaResponse);
    doReturn(cfData).when(this.ptrVentaEcommerceAsyncService).ventaOnlineEntregaTienda(any(PtrVentaOnlineEntregaTiendaRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionVentaAsyncService)
        .savePtrVentaOnlineEntregaTiendaResponse(ptrVentaOnlineEntregaTiendaResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA);

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaTest(
      @Random final PeriodoDto periodo, @Random final PtrVentaTotalizadoRequestDto request,
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResult,
      @Random final PtrVentaTotalizadoResponseDto ptrVentaTotalizadoResponse) {

    doReturn(periodo).when(this.tareaLocalizacionPresupuestoService)
        .findPeriodoPresupuestoYTrabajo(this.runTarea.getTarea().getId());

    cadenas.get(0).setId("1");
    doReturn(cadenas).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());

    doReturn(request).when(this.tareaMapper)
        .mergeTareaDtoAndTareaAmbitoDtoAndPeriodoDtoIdCadenaDtoToPtrVentaTotalizadoRequestDto(
            this.runTarea.getTarea(), this.ambito, periodo, this.recolectarProperties, cadenas);

    doReturn(confProductoVentaResult).when(this.meta4IcmWsCalcIncomeSessionService)
        .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.ambito.getCclIdOrigen());

    final CompletableFuture<PtrVentaTotalizadoResponseDto> cfData = CompletableFuture.completedFuture(ptrVentaTotalizadoResponse);
    doReturn(cfData).when(this.ptrVentaGeneralAsyncService).ventaTotalizado(any(PtrVentaTotalizadoRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionVentaAsyncService)
        .savePtrVentaTotalizadoResponseRepartoOnline(ptrVentaTotalizadoResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionPresupuestoService)
        .findPeriodoPresupuestoYTrabajo(this.runTarea2.getTarea().getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });

  }

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbitoTest(
      @Random final PeriodoDto periodo, @Random final PtrPresenciaDetalleRequestDto request,
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResult,
      @Random final PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto) {

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");
    doReturn(propertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);

    doReturn(Arrays.asList(periodo)).when(this.tareaLocalizacionPresupuestoService)
        .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

    final IdLocalizacionLocalDto localizacionLocalDto = new IdLocalizacionLocalDto();
    localizacionLocalDto.setId("1");

    doReturn(Arrays.asList(localizacionLocalDto)).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
            this.ambito.getCclIdOrigen(),
            Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));

    doReturn(request).when(this.tareaMapper)
        .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(
            this.runTarea.getTarea(), this.ambito, periodo);

    final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = CompletableFuture.completedFuture(ptrPresenciaDetalleResponseDto);
    doReturn(cfData).when(this.ptrPresenciaAsyncService).presenciasDetalle(any(PtrPresenciaDetalleRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionPersonaPresenciaAsyncService)
        .savePtrPresenciaDetalle(ptrPresenciaDetalleResponseDto.getPresenciasDetalle(), this.runTarea.getTarea(),
            TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA.getId());

    this.ventasMonacoService.presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbitoExceptionTest() {

    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();

    doThrow(new RuntimeException()).when(this.tareaLocalizacionHistoricoService)
        .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(any(String.class), any(String.class));

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });

  }

  @Test
  void presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbitoTest(
      @Random final PeriodoDto periodo, @Random final PtrPresenciaDetalleRequestDto request,
      @Random(size = 1, type = IdCadenaDto.class) final List<IdCadenaDto> cadenas,
      @Random(size = 1,
          type = ConfiguracionProductoVentaResultItemDto.class) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResult,
      @Random final PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto) {

    final PtrPropertiesDto propertiesDto = new PtrPropertiesDto();
    final PtrFilterPropertiesDto filter = new PtrFilterPropertiesDto();
    filter.setMaxPageSize(1);
    filter.setMaxPersistenceSize(1);
    filter.setPeriodType(PtrPageEnum.MONTHS);
    filter.setPeriodSize(1);
    propertiesDto.setFilter(filter);
    propertiesDto.setEndpoint("");
    doReturn(propertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);

    doReturn(Arrays.asList(periodo)).when(this.tareaLocalizacionPresupuestoService)
        .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

    final IdLocalizacionLocalDto localizacionLocalDto = new IdLocalizacionLocalDto();
    localizacionLocalDto.setId("1");

    doReturn(Arrays.asList(localizacionLocalDto)).when(this.tareaLocalizacionHistoricoService)
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
            this.ambito.getCclIdOrigen(),
            Arrays.asList(AppConstants.STD_ID_LEG_ENT_MONACO));

    doReturn(request).when(this.tareaMapper)
        .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(
            this.runTarea.getTarea(), this.ambito, periodo);

    final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData = CompletableFuture.completedFuture(ptrPresenciaDetalleResponseDto);
    doReturn(cfData).when(this.ptrPresenciaAsyncService).presenciasDetalle(any(PtrPresenciaDetalleRequestDto.class));

    doReturn(CompletableFuture.completedFuture(null)).when(this.tareaLocalizacionPersonaPresenciaAsyncService)
        .savePtrPresenciaDetalle(ptrPresenciaDetalleResponseDto.getPresenciasDetalle(), this.runTarea.getTarea(),
            TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA_INCLUIDOECOMMERCE.getId());

    this.ventasMonacoService.presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbito(this.runTarea, this.ambito);
  }

  @Test
  void presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbitoExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionPresupuestoService)
        .findPeriodoPresupuestoYTrabajo(this.runTarea2.getTarea().getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbito(this.runTarea2, this.ambito);
    });

  }
}
