package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaProcesarCondicionesAsyncServiceImplTest {

  @Mock
  private RunTareaProcesarCondicionesService tareaProcesarCondicionesService;

  @InjectMocks
  private RunTareaProcesarCondicionesAsyncServiceImpl runTareaProcesarCondicionesAsyncService;

  @ParameterizedTest
  @InstancioSource
  void igualarBandasOrigenDestinoTest(final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.igualarBandasOrigenDestino(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).igualarBandasOrigenDestino(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource
  void establecerBandaOpcionOrigen(final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.establecerBandaOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).establecerBandaOpcionOrigen(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource
  void crearGlobalSeccionOpcionOrigen(final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.crearGlobalSeccionOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).crearGlobalSeccionOpcionOrigen(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource
  void desactivarGlobalSeccionOpcionOrigen(final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.desactivarGlobalSeccionOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).desactivarGlobalSeccionOpcionOrigen(runTarea.getTarea());
  }

}
