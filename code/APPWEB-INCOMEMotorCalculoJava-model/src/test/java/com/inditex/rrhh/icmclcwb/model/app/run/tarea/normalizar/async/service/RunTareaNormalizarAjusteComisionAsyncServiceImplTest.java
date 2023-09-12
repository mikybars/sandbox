/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaNormalizarAjusteComisionAsyncServiceImplTest {

  @Mock
  RunTareaNormalizarAjusteComisionService runTareaNormalizarAjusteComisionService;

  @InjectMocks
  RunTareaNormalizarAjusteComisionAsyncServiceImpl runTareaNormalizarAjusteComisionAsyncService;

  @Test
  void normalizarAjusteComisionTest() {

    final TareaDto tarea = new TareaDto();
    tarea.setId(3883L);

    final CompletableFuture<Void> result = this.runTareaNormalizarAjusteComisionAsyncService
        .normalizarAjusteComision(tarea);

    verify(this.runTareaNormalizarAjusteComisionService, times(1)).normalizarAjusteComision(tarea);

    try {
      assertEquals(AsyncConstants.NIL, result.get());
    } catch (final ExecutionException | InterruptedException e) {
      fail("Se ha producido una excepción que no debería ocurrir.");
    }

  }

}
