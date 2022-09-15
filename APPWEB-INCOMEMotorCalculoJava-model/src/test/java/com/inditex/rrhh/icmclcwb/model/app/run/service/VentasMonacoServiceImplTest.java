package com.inditex.rrhh.icmclcwb.model.app.run.service;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryVentasMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPageEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
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
import com.inditex.rrhh.icmclcwb.model.app.service.VentasMonacoServiceImpl;
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
class VentasMonacoServiceImplTest {

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
  private PrimaryVentasMonacoAsyncService primaryVentasMonacoAsyncService;

  @Mock
  private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  @Mock
  private Map<String, PtrPropertiesDto> ventaGeneralProperties;

  @Mock
  private RecolectarPropertiesDto recolectarProperties;

  @Mock
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Spy
  @InjectMocks
  private VentasMonacoServiceImpl ventasMonacoService;

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

    doReturn(CompletableFuture.completedFuture(null)).when(this.primaryVentasMonacoAsyncService)
        .savePtrVentaTotalizadoResponse(ventaTotalizadoresponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea);

    verify(this.ventasMonacoService, times(1))
        .ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea);
  }

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionPresupuestoService)
        .findPeriodoPresupuestoYTrabajo(this.runTarea2.getTarea().getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea2);
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

    doReturn(CompletableFuture.completedFuture(null)).when(this.primaryVentasMonacoAsyncService)
        .savePtrVentaOnlineIpodResponse(ventaOnlineIpodResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea);
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionHistoricoService)
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(this.runTarea2.getTarea().getId(), this.ambito.getCclIdOrigen(),
            AppConstants.STD_ID_LEG_ENT_MONACO, TipoVentaConceptoEnum.IPOD.getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea2);
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

    doReturn(CompletableFuture.completedFuture(null)).when(this.primaryVentasMonacoAsyncService)
        .savePtrVentaOnlinePickingResponse(ventaOnlinePickingResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlinePickingLocalizacionSeccionByRunTarea(this.runTarea);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlinePickingLocalizacionSeccionByRunTarea(this.runTarea);
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlinePickingLocalizacionSeccionByRunTarea(this.runTarea2);
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

    doReturn(CompletableFuture.completedFuture(null)).when(this.primaryVentasMonacoAsyncService)
        .savePtrVentaOnlineEntregaTiendaResponse(ptrVentaOnlineEntregaTiendaResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea);

    verify(this.ventasMonacoService, times(1))
        .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea);
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_ENTREGA_TIENDA);

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea2);
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

    doReturn(CompletableFuture.completedFuture(null)).when(this.primaryVentasMonacoAsyncService)
        .savePtrVentaTotalizadoResponseRepartoOnline(ptrVentaTotalizadoResponse, this.runTarea.getTarea());

    this.ventasMonacoService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(this.runTarea);
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaExceptionTest() {

    doThrow(new RuntimeException()).when(this.tareaLocalizacionPresupuestoService)
        .findPeriodoPresupuestoYTrabajo(this.runTarea2.getTarea().getId());

    assertThrows(RuntimeException.class, () -> {
      this.ventasMonacoService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(this.runTarea2);
    });

  }
}
