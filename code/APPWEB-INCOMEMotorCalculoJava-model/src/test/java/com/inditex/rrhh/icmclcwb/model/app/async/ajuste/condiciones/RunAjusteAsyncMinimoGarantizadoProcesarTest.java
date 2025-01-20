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
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones.RunAjusteMinimoGarantizadoProcesar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunAjusteAsyncMinimoGarantizadoProcesarTest {

  @Mock
  private RunAjusteMinimoGarantizadoProcesar runAjusteMinimoGarantizadoProcesar;

  @InjectMocks
  private RunAjusteAsyncMinimioGarantizadoProcesar runAjusteAsyncMinimioGarantizadoProcesar;

  @Test
  void executeTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(890L);
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(19L);
    final RunTareaDto runTarea = RunTareaDto
        .builder()
        .tarea(tarea)
        .trabajo(trabajo)
        .build();
    final AlgoritmoAjusteDto algoritmo = new AlgoritmoAjusteDto();
    algoritmo.setId(19);
    final CompletableFuture<Void> cf = this.runAjusteAsyncMinimioGarantizadoProcesar.execute(runTarea, algoritmo);
    verify(this.runAjusteMinimoGarantizadoProcesar, times(1)).execute(runTarea, algoritmo);
    assertNotNull(cf);
  }

}
