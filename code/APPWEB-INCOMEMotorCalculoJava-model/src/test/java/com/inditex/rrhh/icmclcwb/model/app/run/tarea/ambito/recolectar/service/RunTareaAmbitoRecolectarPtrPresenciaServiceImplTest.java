package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTipoHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTipoHoraService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrFilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class RunTareaAmbitoRecolectarPtrPresenciaServiceImplTest {

  @Mock
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Mock
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Mock
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @Mock
  private TareaMapper tareaMapper;

  @Mock
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Mock
  private TareaTipoHoraService tareaTipoHoraService;

  @Mock
  @Qualifier("presenciasProperties")
  private Map<String, PtrPropertiesDto> presenciasProperties;

  @Mock
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Spy
  @InjectMocks
  RunTareaAmbitoRecolectarPtrPresenciaServiceImpl runTareaAmbitoRecolectarPtrPresenciaServiceImpl;

  TareaDto tarea = Instancio.create(TareaDto.class);

  RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  TareaAmbitoDto tareaAmbitoDto = Instancio.create(TareaAmbitoDto.class);

  List<IdCadenaDto> idCadenaDtoList = Instancio.ofList(IdCadenaDto.class).size(1).create();

  List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList = Instancio.ofList(IdLocalizacionLocalDto.class).size(1).create();

  List<IdEmpresaDto> idEmpresaDtoList = Instancio.ofList(IdEmpresaDto.class).size(1).create();

  @BeforeEach
  void setup() {
    this.idCadenaDtoList.get(0).setId("1");
    this.idLocalizacionLocalDtoList.get(0).setId("1");
    this.idEmpresaDtoList.get(0).setStdIdLegEnt("1");
  }

  @Test
  void getFechaInicioPeriodoTest() {
    final String result = this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl.getFechaInicioPeriodo(this.tarea);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void presenciaDetallePersonaByRunTareaAndTareaAmbitoTest(final PtrPropertiesDto ptrPropertiesDto,
      final List<PeriodoDto> periodoDtoList,
      final PtrPresenciaDetalleRequestDto ptrPresenciaDetalleRequestDto,
      final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      final PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      // Modificamos datos a un formato adecuado
      this.idEmpresaDtoList.get(0).setStdIdLegEnt("1");
      doReturn(this.idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());

      // Modificamos datos a un formato adecuado
      this.idLocalizacionLocalDtoList.get(0).setId("1");
      // localizaciones
      final List<String> empresasAmbito = this.idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList());

      doReturn(this.idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbitoDto.getCclIdOrigen(),
              empresasAmbito);
      // ficticias
      doReturn(this.idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(this.tareaAmbitoDto.getCclIdOrigen(), PtrConstants.EMPRESA_0);

      doReturn(periodoDtoList).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
          this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);
      doReturn(ptrPresenciaDetalleRequestDto).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(any(TareaDto.class), any(TareaAmbitoDto.class),
              any(PeriodoDto.class));

      // Acondicionamiento de los datos
      final List<IdLocalizacionLocalDto> iter = StreamUtils.partition(
          Stream.concat(this.idLocalizacionLocalDtoList.stream(), this.idLocalizacionLocalDtoList.stream())
              .collect(Collectors.toList()),
          ptrPropertiesDto.getFilter().getMaxPageSize()).stream().findFirst().orElse(null);
      ptrPresenciaDetalleRequestDto
          .setEmpresa(empresasAmbito.stream().map(Integer::valueOf).collect(Collectors.toList()));
      ptrPresenciaDetalleRequestDto.setTienda(iter.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList()));
      ptrPresenciaDetalleRequestDto.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
      ptrPresenciaDetalleRequestDto
          .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());
      doReturn(cfData).when(this.ptrPresenciaAsyncService).presenciasDetalle(ptrPresenciaDetalleRequestDto);

      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl
          .presenciaDetallePersonaByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

      verify(this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl, times(1))
          .presenciaDetallePersonaByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

    }
  }

  @Test
  void presenciaDetallePersonaByRunTareaAndTareaAmbitoExceptionTest() {
    doThrow(new RuntimeException()).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl
          .presenciaDetallePersonaByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);
    });
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbitoTest(final PtrPropertiesDto ptrPropertiesDto,
      final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      final PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto,
      final List<PeriodoDto> periodoDtoList,
      final PtrPresenciaDetalleRequestDto paramPresenciasDetalle) {

    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      // Modificamos datos a un formato adecuado
      this.idCadenaDtoList.get(0).setId("1");
      doReturn(this.idCadenaDtoList).when(this.tareaLocalizacionHistoricoService).findIdCadenaDtoByIdTareaAndCclIdOrigen(
          this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
          Collections.singletonList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));

      doReturn(this.idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
              this.idCadenaDtoList.stream().map(IdCadenaDto::getId).collect(Collectors.toList()));

      doReturn(periodoDtoList).when(this.tareaLocalizacionPresupuestoService)
          .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);

      doReturn(paramPresenciasDetalle).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(any(TareaDto.class), any(TareaAmbitoDto.class),
              any(PeriodoDto.class));

      final List<IdLocalizacionLocalDto> iter = StreamUtils.partition(this.idLocalizacionLocalDtoList,
          ptrPropertiesDto.getFilter().getMaxPageSize()).stream().findFirst().orElse(null);
      iter.get(0).setId("1");

      paramPresenciasDetalle
          .setCadena(
              this.idCadenaDtoList.stream().map(a -> Integer.valueOf(a.getId())).collect(Collectors.toList()));
      paramPresenciasDetalle.setTienda(iter.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList()));
      paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
      paramPresenciasDetalle
          .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());

      doReturn(cfData).when(this.ptrPresenciaAsyncService).presenciasDetalle(paramPresenciasDetalle);

      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl
          .presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);

      verify(this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl, times(1))
          .presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);
    }
  }

  @Test
  void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbitoExceptionTest() {
    doThrow(new RuntimeException()).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl
          .presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);
    });
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbitoTest(final PtrPropertiesDto ptrPropertiesDto,
      final List<TareaTipoHoraDto> tiposHoras,
      final List<PeriodoDto> periodos,
      final PtrPresenciaDetalleRequestDto paramPresenciasDetalle,
      final CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      final PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto,
      final CompletableFuture<Void> savePtrPresenciaDetalle) {
    try (final MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      final PtrFilterPropertiesDto filter = ptrPropertiesDto.getFilter();

      doReturn(this.idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());
      this.idEmpresaDtoList.get(0).setStdIdLegEnt("1");

      doReturn(tiposHoras).when(this.tareaTipoHoraService)
          .findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(this.runTarea.getTarea());

      doReturn(this.idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbitoDto.getCclIdOrigen(),
              this.idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));

      doReturn(periodos).when(this.tareaLocalizacionPresupuestoService)
          .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

      doReturn(paramPresenciasDetalle).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(any(TareaDto.class), any(TareaAmbitoDto.class),
              any(PeriodoDto.class));
      // Acondicionamiento de paramPresenciasDetalle
      paramPresenciasDetalle
          .setEmpresa(
              this.idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()).stream()
                  .map(Integer::valueOf).collect(Collectors.toList()));

      final List<IdLocalizacionLocalDto> iter = StreamUtils.partition(this.idLocalizacionLocalDtoList,
          filter.getMaxPageSize()).stream().findFirst().orElse(null);
      iter.get(0).setId("1");
      paramPresenciasDetalle.setTienda(iter.stream()
          .map(IdLocalizacionLocalDto::getId)
          .map(Integer::valueOf)
          .collect(Collectors.toList()));
      paramPresenciasDetalle.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
      paramPresenciasDetalle.setTipo(tiposHoras.stream()
          .map(TareaTipoHoraDto::getIdTipoHora)
          .collect(Collectors.toList()));
      paramPresenciasDetalle
          .setAgrupacion(PtrGroupTypeEnum.FECHA_TIENDA_TIPOHORA_SECCION.getValue());

      doReturn(cfData).when(this.ptrPresenciaAsyncService).presenciasDetalle(paramPresenciasDetalle);

      doReturn(savePtrPresenciaDetalle).when(this.tareaLocalizacionPersonaPresenciaAsyncService)
          .savePtrPresenciaDetalle(ptrPresenciaDetalleResponseDto.getPresenciasDetalle(),
              this.runTarea.getTarea(), TipoDatoEnum.PRESENCIA_REAL_LOCALIZACION_SECCION_PERSONA_TIPOHORA_REPARTIDOPROVINCIA.getId());

      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl.presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(this.runTarea,
          this.tareaAmbitoDto);

      verify(this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl, times(1))
          .presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);
    }
  }

  @Test
  void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbitoExceptionTest() {
    doThrow(new RuntimeException()).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl
          .presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(this.runTarea, this.tareaAmbitoDto);
    });
  }

}
