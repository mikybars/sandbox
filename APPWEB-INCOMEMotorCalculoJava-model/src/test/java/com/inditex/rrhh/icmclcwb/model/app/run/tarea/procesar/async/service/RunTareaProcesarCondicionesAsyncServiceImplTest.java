package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaProcesarCondicionesAsyncServiceImplTest {

  @Mock
  private RunTareaProcesarCondicionesService tareaProcesarCondicionesService;

  @InjectMocks
  private RunTareaProcesarCondicionesAsyncServiceImpl runTareaProcesarCondicionesAsyncService;

  @Test
  void igualarBandasOrigenDestinoTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(89898L);
    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(tarea);

    this.runTareaProcesarCondicionesAsyncService.igualarBandasOrigenDestino(runTarea);

    verify(this.tareaProcesarCondicionesService, times(1)).igualarBandasOrigenDestino(tarea);
  }

}
