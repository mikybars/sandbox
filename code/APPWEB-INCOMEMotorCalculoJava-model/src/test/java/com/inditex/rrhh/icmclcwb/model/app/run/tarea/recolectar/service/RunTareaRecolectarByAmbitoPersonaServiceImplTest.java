package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarByAmbitoPersonaServiceImplTest {
  @Mock
  private TareaCalculoPersonaAsyncService tareaCalculoPersonaAsyncService;

  @InjectMocks
  private RunTareaRecolectarByAmbitoPersonaServiceImpl runTareaRecolectarByAmbitoPersonaService;

  @Test
  void runTest() {
    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class))).thenReturn(cf);
    this.runTareaRecolectarByAmbitoPersonaService.run(new RunTareaDto());
    verify(this.tareaCalculoPersonaAsyncService).mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class));
  }

  @Test
  void runExceptionTest() {
    doThrow(new RuntimeException("EE")).when(this.tareaCalculoPersonaAsyncService)
        .mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class));
    final RunTareaDto tarea = new RunTareaDto();
    assertThrows(RuntimeException.class, () -> this.runTareaRecolectarByAmbitoPersonaService.run(tarea));
  }
}
