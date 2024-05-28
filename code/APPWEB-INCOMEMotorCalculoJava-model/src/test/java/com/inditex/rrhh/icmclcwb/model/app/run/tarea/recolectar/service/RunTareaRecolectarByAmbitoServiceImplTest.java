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
class RunTareaRecolectarByAmbitoServiceImplTest {
  @Mock
  private TareaCalculoPersonaAsyncService tareaCalculoPersonaAsyncService;

  @InjectMocks
  private RunTareaRecolectarByAmbitoServiceImpl runTareaRecolectarByAmbitoService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbito(any(RunTareaDto.class))).thenReturn(cf);
    this.runTareaRecolectarByAmbitoService.run(runTarea);
    verify(this.tareaCalculoPersonaAsyncService).mergePersonaCalculoByAmbito(any(RunTareaDto.class));
  }

  @Test
  void runExceptionTest() {
    doThrow(new RuntimeException("EE")).when(this.tareaCalculoPersonaAsyncService).mergePersonaCalculoByAmbito(any(RunTareaDto.class));
    assertThrows(RuntimeException.class, () -> this.runTareaRecolectarByAmbitoService.run(new RunTareaDto()));
  }
}
