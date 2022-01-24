/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.async.ajuste.condiciones;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteBajaItProcesar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunAjusteAsyncBajaItProcesarTest {

  @Mock
  private RunAjusteBajaItProcesar runAjusteBajaItProcesar;

  @InjectMocks
  private RunAjusteAsyncBajaItProcesar runAjusteAsyncBajaItProcesar;

  @Test
  void executeTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(890L);
    final RunTareaDto runTarea = RunTareaDto
        .builder()
        .tarea(tarea)
        .build();
    final AlgoritmoAjusteDto algoritmo = new AlgoritmoAjusteDto();
    algoritmo.setId(19);
    final CompletableFuture<Void> cf = this.runAjusteAsyncBajaItProcesar.execute(runTarea, algoritmo);
    verify(this.runAjusteBajaItProcesar, times(1)).execute(runTarea, algoritmo);
    assertNotNull(cf);
  }

}
