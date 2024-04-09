package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarAmbitoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarEstructurasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiposHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto.ValidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaRecolectarValidarServiceImplTest {

  @Mock
  private RunTareaRecolectarValidarEstructurasAsyncService runTareaRecolectarValidarEstructurasAsyncService;

  @Mock
  private RunTareaRecolectarValidarLocalizacionHistoricoAsyncService runTareaRecolectarValidarLocalizacionHistoricoAsyncService;

  @Mock
  private RunTareaRecolectarValidarTiposHoraAsyncService runTareaRecolectarValidarTiposHoraAsyncService;

  @Mock
  private RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;

  @Mock
  private RunTareaRecolectarValidarLocalizacionPresenciaAsyncService runTareaRecolectarValidarLocalizacionPresenciaAsyncService;

  @Mock
  private RunTareaRecolectarValidarLocalizacionVentaAsyncService runTareaRecolectarValidarLocalizacionVentaAsyncService;

  @Mock
  private RunTareaRecolectarValidarAmbitoAsyncService runTareaRecolectarValidarAmbitoAsyncService;

  @Mock
  @Qualifier("validarProperties")
  private ValidarPropertiesDto validarProperties;

  @Mock
  private Logger log;

  @Mock
  private TareaFaseService tareaFaseService;

  @Spy
  @InjectMocks
  private RunTareaRecolectarValidarServiceImpl runTareaRecolectarValidarServiceImpl;

  @Random
  private RunTareaDto runTarea;

  @Test
  void runTest(@Random TareaFaseDto tareaFaseDto,
      @Random CompletableFuture<List<RunTareaValidarDto>> completableFuture,
      @Random(type = RunTareaValidarDto.class, size = 2) List<RunTareaValidarDto> runTareaValidarDtoList) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {

      doReturn(tareaFaseDto).when(this.tareaFaseService).findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTrabajo().getId(),
          FaseEnum.VALIDAR_RECOLECCION.getId());

      doReturn(true).when(this.validarProperties).isEnabled();
      doReturn(true).when(this.validarProperties).isLogging();

      doReturn(completableFuture).when(this.runTareaRecolectarValidarEstructurasAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionHistoricoAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarTiposHoraAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionPresenciaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionVentaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarAmbitoAsyncService).run(this.runTarea);

      utilities.when(() -> AsyncUtils.get(completableFuture)).thenReturn(runTareaValidarDtoList);

      this.runTareaRecolectarValidarServiceImpl.run(this.runTarea);

      verify(this.runTareaRecolectarValidarServiceImpl, times(1))
          .run(this.runTarea);
    }
  }

  @Test
  void runExceptionTest(@Random TareaFaseDto tareaFaseDto,
      @Random CompletableFuture<List<RunTareaValidarDto>> completableFuture,
      @Random(type = RunTareaValidarDto.class, size = 2) List<RunTareaValidarDto> runTareaValidarDtoList) {

    try (MockedStatic<AsyncUtils> utilities = Mockito.mockStatic(AsyncUtils.class)) {

      doReturn(tareaFaseDto).when(this.tareaFaseService).findTareaFaseDtoByIdTareaAndIdFase(this.runTarea.getTrabajo().getId(),
          FaseEnum.VALIDAR_RECOLECCION.getId());

      doReturn(true).when(this.validarProperties).isEnabled();
      doReturn(false).when(this.validarProperties).isLogging();
      doReturn(true).when(this.validarProperties).isException();

      doReturn(completableFuture).when(this.runTareaRecolectarValidarEstructurasAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionHistoricoAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarTiposHoraAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionPresenciaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarLocalizacionVentaAsyncService).run(this.runTarea);

      doReturn(completableFuture).when(this.runTareaRecolectarValidarAmbitoAsyncService).run(this.runTarea);

      utilities.when(() -> AsyncUtils.get(completableFuture)).thenReturn(runTareaValidarDtoList);

      assertThrows(IcmclcwbException.class, () -> {
        this.runTareaRecolectarValidarServiceImpl.run(this.runTarea);
      });
    }
  }

  // @Test
  // void runExceptionTest (@Random TareaFaseDto tareaFaseDto) {
  //
  // doThrow(new RuntimeException()).when(this.validarProperties).isEnabled();;
  //
  // doReturn(tareaFaseDto).when(this.tareaFaseService).findTareaFaseDtoByIdTareaAndIdFase
  // (this.runTarea.getTrabajo().getId(), FaseEnum.VALIDAR_RECOLECCION.getId());
  //
  // assertThrows(RuntimeException.class, () -> {
  // this.runTareaRecolectarValidarServiceImpl.run(this.runTarea);
  // });
  //
  // }

}
