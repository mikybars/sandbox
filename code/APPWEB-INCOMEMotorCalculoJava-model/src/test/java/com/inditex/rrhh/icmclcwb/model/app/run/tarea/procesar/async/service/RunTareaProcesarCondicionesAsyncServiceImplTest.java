package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaProcesarCondicionesAsyncServiceImplTest {

  @Mock
  private RunTareaProcesarCondicionesService tareaProcesarCondicionesService;

  @InjectMocks
  private RunTareaProcesarCondicionesAsyncServiceImpl runTareaProcesarCondicionesAsyncService;

  @Test
  void igualarBandasOrigenDestinoTest(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.igualarBandasOrigenDestino(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).igualarBandasOrigenDestino(runTarea.getTarea());
  }

  @Test
  void establecerBandaOpcionOrigen(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.establecerBandaOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).establecerBandaOpcionOrigen(runTarea.getTarea());
  }

  @Test
  void crearGlobalSeccionOpcionOrigen(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.crearGlobalSeccionOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).crearGlobalSeccionOpcionOrigen(runTarea.getTarea());
  }

  @Test
  void desactivarGlobalSeccionOpcionOrigen(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarCondicionesAsyncService.desactivarGlobalSeccionOpcionOrigen(runTarea);
    verify(this.tareaProcesarCondicionesService, times(1)).desactivarGlobalSeccionOpcionOrigen(runTarea.getTarea());
  }

}
