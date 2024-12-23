package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarByAmbitoLocalizacionServiceImplTest {
  @Mock
  private TareaCalculoPersonaAsyncService tareaCalculoPersonaAsyncService;

  @InjectMocks
  private RunTareaRecolectarByAmbitoLocalizacionServiceImpl runTareaRecolectarByAmbitoLocalizacionService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    this.runTareaRecolectarByAmbitoLocalizacionService.run(runTarea);
    verify(this.tareaCalculoPersonaAsyncService).mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class));

  }

  @Test
  void runExceptionTest() {
    doThrow(new RuntimeException("e"))
        .when(this.tareaCalculoPersonaAsyncService).mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class));
    final RunTareaDto tarea = new RunTareaDto();
    assertThrows(RuntimeException.class,
        () -> this.runTareaRecolectarByAmbitoLocalizacionService.run(tarea));
  }
}
