package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;
import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresupuestoVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrExcluirIpodEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrIncluirVentaPatEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImplTest {

  @Mock
  @Qualifier("ventaEcommerceProperties")
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Mock
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  TareaAmbitoDto tareaAmbitoDto = Instancio.create(TareaAmbitoDto.class);

  List<IdCadenaDto> idCadenaDtoList = Instancio.ofList(IdCadenaDto.class).size(1).create();

  List<PeriodoDto> periodoDtoList = Instancio.ofList(PeriodoDto.class).size(1).create();

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaLocalizacionVentaAsyncService tareaLocalizacionVentaAsyncService;

  @Mock
  private TareaLocalizacionPresupuestoVentaAsyncService tareaLocalizacionPresupuestoVentaAsyncService;

  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Mock
  private PtrVentaEcommerceAsyncService ptrVentaEcommerceAsyncService;

  @Mock
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Spy
  @InjectMocks
  RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl runTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl;

  @Mock
  private TareaMapper tareaMapper;

  @BeforeEach
  void setup() {
    this.idCadenaDtoList.get(0).setId("1");
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(final PtrPropertiesDto ptrPropertiesDto,
      final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResultItemDtoList,
      final PtrVentaOnlinePickingRequestDto ptrVentaOnlinePickingRequestDto,
      final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData,
      final PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrVentaOnlinePickingResponseDto);

      doReturn(ptrPropertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);
      this.idCadenaDtoList.get(0).setId("1");
      doReturn(this.idCadenaDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
              TipoVentaConceptoEnum.SINT.getId());

      final List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList =
          Arrays.asList(new IdLocalizacionLocalDto("1"), new IdLocalizacionLocalDto("2"));

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
              this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen());

      final LocalizacionesAmbitoDto localizacionesAmbitoDto = new LocalizacionesAmbitoDto(4L);
      localizacionesAmbitoDto.setLocalizaciones(idLocalizacionLocalDtoList);

      doReturn(this.periodoDtoList).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
          this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);
      doReturn(ptrVentaOnlinePickingRequestDto).when(this.tareaMapper)
          .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(this.runTarea.getTarea(), this.tareaAmbitoDto,
              this.periodoDtoList.get(0));

      doReturn(confProductoVentaResultItemDtoList).when(this.meta4IcmWsCalcIncomeSessionService)
          .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen());

      ptrVentaOnlinePickingRequestDto
          .setCadena(this.idCadenaDtoList.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
      ptrVentaOnlinePickingRequestDto.setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_SECCION);
      ptrVentaOnlinePickingRequestDto.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
      ptrVentaOnlinePickingRequestDto.setTienda(localizacionesAmbitoDto.getLocalizaciones());
      ptrVentaOnlinePickingRequestDto.setProducto(confProductoVentaResultItemDtoList.stream()
          .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
          .collect(Collectors.toList()));
      ptrVentaOnlinePickingRequestDto.setVentaPAT(PtrIncluirVentaPatEnum.TRUE.getValue());
      ptrVentaOnlinePickingRequestDto.setExcluirIpod(PtrExcluirIpodEnum.FALSE.getValue());

      doReturn(cfData).when(this.ptrVentaEcommerceAsyncService).ventaOnlinePicking(ptrVentaOnlinePickingRequestDto);

      this.runTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl
          .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

      verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl, times(1))
          .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

    }
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(final PtrPropertiesDto ptrPropertiesDto,
      final List<IdLocalizacionLocalPresupuestoDto> idLocalizacionLocalPresupuestoDto,
      final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResultItemDtoList,
      final PtrVentaOnlinePickingRequestDto ptrVentaOnlinePickingRequestDto,
      final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData,
      final PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrVentaOnlinePickingResponseDto);

      doReturn(ptrPropertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);

      final List<IdEmpresaDto> idEmpresaList = new ArrayList<>();
      idEmpresaList.add(IdEmpresaDto.builder().stdIdLegEnt("1").build());
      idEmpresaList.add(IdEmpresaDto.builder().stdIdLegEnt("2").build());
      doReturn(idEmpresaList).when(this.tareaAmbitoGlobalEmpresaService)
          .findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());

      final List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList =
          Arrays.asList(new IdLocalizacionLocalDto("1"), new IdLocalizacionLocalDto("2"));

      doReturn(idLocalizacionLocalPresupuestoDto).when(this.tareaLocalizacionHistoricoService)
          .findTiendasPresupuestosByStdIdLegEntAndIdTarea(
              idEmpresaList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()), this.runTarea.getTarea().getId(),
              Collections.singletonList(
                  TipoVentaConceptoChallengeEnum.SINT.getId()));

      doReturn(ptrVentaOnlinePickingRequestDto).when(this.tareaMapper)
          .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlinePickingRequestDto(
              any(TrabajoDTO.class), any(TareaDto.class), any(TareaAmbitoDto.class), any(IdLocalizacionLocalPresupuestoDto.class));

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(this.runTarea.getTarea().getId(),
              idLocalizacionLocalPresupuestoDto.get(0).getIdTipoPresupuesto(),
              idLocalizacionLocalPresupuestoDto.get(0).getFechaInicio(),
              idLocalizacionLocalPresupuestoDto.get(0).getFechaFin());

      doReturn(confProductoVentaResultItemDtoList).when(this.meta4IcmWsCalcIncomeSessionService)
          .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen());

      ptrVentaOnlinePickingRequestDto.setAgrupacion(PtrGroupTypeEnum.TIENDA_SECCION);
      ptrVentaOnlinePickingRequestDto.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
      ptrVentaOnlinePickingRequestDto
          .setEmpresa(idEmpresaList.stream().map(IdEmpresaDto::getStdIdLegEnt).map(Integer::valueOf).collect(Collectors.toList()));
      ptrVentaOnlinePickingRequestDto.setTienda(idLocalizacionLocalDtoList
          .stream().map(x -> Integer.valueOf(x.getId()))
          .collect(Collectors.toList()));
      ptrVentaOnlinePickingRequestDto.setProducto(
          confProductoVentaResultItemDtoList.stream()
              .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
              .collect(Collectors.toList()));

      doReturn(cfData).when(this.ptrVentaEcommerceAsyncService).ventaOnlinePicking(ptrVentaOnlinePickingRequestDto);

      this.runTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl
          .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

      verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceServiceImpl, times(1))
          .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

    }
  }

}
