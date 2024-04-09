package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
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

  @Random
  TareaDto tarea;

  @Random
  RunTareaDto runTarea;

  @Random
  TareaAmbitoDto tareaAmbitoDto;

  @Test
  void getFechaInicioPeriodoTest() {
    final String result = this.runTareaAmbitoRecolectarPtrPresenciaServiceImpl.getFechaInicioPeriodo(this.tarea);

    assertNotNull(result);
  }

  @Test
  void presenciaDetallePersonaByRunTareaAndTareaAmbitoTest(@Random PtrPropertiesDto ptrPropertiesDto,
      @Random(type = IdEmpresaDto.class, size = 2) List<IdEmpresaDto> idEmpresaDtoList,
      @Random(type = PeriodoDto.class, size = 1) List<PeriodoDto> periodoDtoList,
      @Random(type = IdLocalizacionLocalDto.class, size = 1) List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList,
      @Random PtrPresenciaDetalleRequestDto ptrPresenciaDetalleRequestDto,
      @Random CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      @Random PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      // Modificamos datos a un formato adecuado
      idEmpresaDtoList.get(0).setStdIdLegEnt("1");
      idEmpresaDtoList.get(1).setStdIdLegEnt("2");
      doReturn(idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());

      // Modificamos datos a un formato adecuado
      idLocalizacionLocalDtoList.get(0).setId("1");
      // localizaciones
      List<String> empresasAmbito = idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList());

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbitoDto.getCclIdOrigen(),
              empresasAmbito);
      // ficticias
      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(this.tareaAmbitoDto.getCclIdOrigen(), PtrConstants.EMPRESA_0);

      doReturn(periodoDtoList).when(this.tareaLocalizacionPresupuestoService).findListaPeriodosPresupestoYTrabajo(
          this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);
      doReturn(ptrPresenciaDetalleRequestDto).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(this.runTarea.getTarea(), this.tareaAmbitoDto,
              periodoDtoList.get(0));

      // Acondicionamiento de los datos
      List<IdLocalizacionLocalDto> iter = StreamUtils.partition(
          Stream.concat(idLocalizacionLocalDtoList.stream(), idLocalizacionLocalDtoList.stream())
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

  @Test
  void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbitoTest(@Random PtrPropertiesDto ptrPropertiesDto,
      @Random(type = IdCadenaDto.class, size = 2) List<IdCadenaDto> idCadenaDtoList,
      @Random CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      @Random PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto,
      @Random(type = IdLocalizacionLocalDto.class, size = 2) List<IdLocalizacionLocalDto> idLocalizacionLocalDtoList,
      @Random(type = PeriodoDto.class, size = 1) List<PeriodoDto> periodoDtoList,
      @Random PtrPresenciaDetalleRequestDto paramPresenciasDetalle) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      // Modificamos datos a un formato adecuado
      idCadenaDtoList.get(0).setId("1");
      idCadenaDtoList.get(1).setId("2");
      doReturn(idCadenaDtoList).when(this.tareaLocalizacionHistoricoService).findIdCadenaDtoByIdTareaAndCclIdOrigen(
          this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
          Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));

      doReturn(idLocalizacionLocalDtoList).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(this.runTarea.getTarea().getId(), this.tareaAmbitoDto.getCclIdOrigen(),
              idCadenaDtoList.stream().map(IdCadenaDto::getId).collect(Collectors.toList()));

      doReturn(periodoDtoList).when(this.tareaLocalizacionPresupuestoService)
          .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), ptrPropertiesDto.getFilter(), this.recolectarProperties);

      doReturn(paramPresenciasDetalle).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(this.runTarea.getTarea(), this.tareaAmbitoDto,
              periodoDtoList.get(0));

      List<IdLocalizacionLocalDto> iter = StreamUtils.partition(idLocalizacionLocalDtoList,
          ptrPropertiesDto.getFilter().getMaxPageSize()).stream().findFirst().orElse(null);
      iter.get(0).setId("1");
      iter.get(1).setId("2");

      paramPresenciasDetalle
          .setCadena(
              idCadenaDtoList.stream().map(a -> Integer.valueOf(a.getId())).collect(Collectors.toList()));
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

  @Test
  void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbitoTest(@Random PtrPropertiesDto ptrPropertiesDto,
      @Random(type = IdEmpresaDto.class, size = 2) List<IdEmpresaDto> idEmpresaDtoList,
      @Random(type = TareaTipoHoraDto.class, size = 2) List<TareaTipoHoraDto> tiposHoras,
      @Random(type = IdLocalizacionLocalDto.class, size = 1) List<IdLocalizacionLocalDto> localizaciones,
      @Random(type = PeriodoDto.class, size = 1) List<PeriodoDto> periodos,
      @Random PtrPresenciaDetalleRequestDto paramPresenciasDetalle,
      @Random CompletableFuture<PtrPresenciaDetalleResponseDto> cfData,
      @Random PtrPresenciaDetalleResponseDto ptrPresenciaDetalleResponseDto,
      @Random CompletableFuture<Void> savePtrPresenciaDetalle) {
    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {
      utilities.when(() -> AsyncUtils.get(cfData))
          .thenReturn(ptrPresenciaDetalleResponseDto);

      doReturn(ptrPropertiesDto).when(this.presenciasProperties).get(PtrPropertiesConstants.PRESENCIA_DETALLE);
      PtrFilterPropertiesDto filter = ptrPropertiesDto.getFilter();

      doReturn(idEmpresaDtoList).when(this.tareaAmbitoGlobalEmpresaService).findIdEmpresaByIdTarea(this.runTarea.getTarea().getId());
      idEmpresaDtoList.get(0).setStdIdLegEnt("1");
      idEmpresaDtoList.get(1).setStdIdLegEnt("2");

      doReturn(tiposHoras).when(this.tareaTipoHoraService)
          .findByIdTareaAndExcluidoDenominadorYRepartidoProvincia(this.runTarea.getTarea());

      doReturn(localizaciones).when(this.tareaLocalizacionHistoricoService)
          .findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(this.runTarea.getTarea().getId(),
              this.tareaAmbitoDto.getCclIdOrigen(),
              idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()));

      doReturn(periodos).when(this.tareaLocalizacionPresupuestoService)
          .findListaPeriodosPresupestoYTrabajo(this.runTarea.getTarea().getId(), filter, this.recolectarProperties);

      doReturn(paramPresenciasDetalle).when(this.tareaMapper)
          .mergeAndTareaDtoAndTareaAmbitoDtoAndPeriodoDtoToPtrPresenciasDetalleRequestDto(this.runTarea.getTarea(), this.tareaAmbitoDto,
              periodos.get(0));
      // Acondicionamiento de paramPresenciasDetalle
      paramPresenciasDetalle
          .setEmpresa(
              idEmpresaDtoList.stream().map(IdEmpresaDto::getStdIdLegEnt).collect(Collectors.toList()).stream()
                  .map(Integer::valueOf).collect(Collectors.toList()));

      List<IdLocalizacionLocalDto> iter = StreamUtils.partition(localizaciones,
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
