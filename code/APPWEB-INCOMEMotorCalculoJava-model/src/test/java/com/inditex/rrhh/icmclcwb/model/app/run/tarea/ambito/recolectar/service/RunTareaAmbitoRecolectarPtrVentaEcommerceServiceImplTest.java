package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoRecolectarPtrVentaEcommerceServiceImplTest {

  @Mock
  @Qualifier("ventaEcommerceProperties")
  private Map<String, PtrPropertiesDto> ventaEcommerceProperties;

  @Mock
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Random
  RunTareaDto runTarea;

  @Random
  TareaAmbitoDto tareaAmbitoDto;

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

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Random final PtrPropertiesDto ptrPropertiesDto,
      @Random(type = IdCadenaDto.class, size = 2) final List<IdCadenaDto> idCadenaDtoList,
      @Random(type = PeriodoDto.class, size = 1) final List<PeriodoDto> periodoDtoList,
      @Random(type = ConfiguracionProductoVentaResultItemDto.class,
          size = 2) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResultItemDtoList,
      @Random final PtrVentaOnlinePickingRequestDto ptrVentaOnlinePickingRequestDto,
      @Random final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData,
      @Random final PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrVentaOnlinePickingResponseDto);

      doReturn(ptrPropertiesDto).when(this.ventaEcommerceProperties).get(PtrPropertiesConstants.VENTA_ONLINE_PICKING);
      idCadenaDtoList.get(0).setId("1");
      idCadenaDtoList.get(1).setId("2");
      doReturn(idCadenaDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdCadenaDtoByIdTareaAndCclIdOrigen(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
              TipoVentaConceptoEnum.SINT.getId());

      final List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList =
          Arrays.asList(new IdLocalizacionLocalDto("1"), new IdLocalizacionLocalDto("2"));

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
              this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen());

      final LocalizacionesAmbitoDto localizacionesAmbitoDto = new LocalizacionesAmbitoDto(4L);
      localizacionesAmbitoDto.setLocalizaciones(idLocalizacionLocalDtoList);

      doReturn(periodoDtoList).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
          this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);
      doReturn(ptrVentaOnlinePickingRequestDto).when(this.tareaMapper)
          .mergeTareaDtoAndTareaAmbitoDtoPeriodoDtoToPtrVentaOnlinePickingRequestDto(this.runTarea.getTarea(), this.tareaAmbitoDto,
              periodoDtoList.get(0));

      doReturn(confProductoVentaResultItemDtoList).when(this.meta4IcmWsCalcIncomeSessionService)
          .getConfiguracionProductoVenta(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen());

      ptrVentaOnlinePickingRequestDto
          .setCadena(idCadenaDtoList.stream().map(IdCadenaDto::getId).map(Integer::valueOf).collect(Collectors.toList()));
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

  @Test
  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(@Random final PtrPropertiesDto ptrPropertiesDto,
      @Random(type = IdLocalizacionLocalPresupuestoDto.class,
          size = 1) final List<IdLocalizacionLocalPresupuestoDto> idLocalizacionLocalPresupuestoDto,
      @Random(type = ConfiguracionProductoVentaResultItemDto.class,
          size = 2) final List<ConfiguracionProductoVentaResultItemDto> confProductoVentaResultItemDtoList,
      @Random final PtrVentaOnlinePickingRequestDto ptrVentaOnlinePickingRequestDto,
      @Random final CompletableFuture<PtrVentaOnlinePickingResponseDto> cfData,
      @Random final PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto) {

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
              Arrays.asList(
                  TipoVentaConceptoChallengeEnum.SINT.getId()));

      doReturn(ptrVentaOnlinePickingRequestDto).when(this.tareaMapper)
          .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoAndIdLocalizacionLocalPresupuestoDtoToPtrVentaOnlinePickingRequestDto(
              this.runTarea.getTrabajo(), this.runTarea.getTarea(), this.tareaAmbitoDto,
              idLocalizacionLocalPresupuestoDto.get(0));

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
