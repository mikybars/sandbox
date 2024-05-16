package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaConsolidarByAmbitoServiceImplTest {
  @Mock
  private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @InjectMocks
  private RunTareaConsolidarByAmbitoServiceImpl runTareaConsolidarByAmbitoService;

  @Test
  void runTest() {
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoPersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoCalculoPersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacionPersona(any(RunTareaDto.class))).thenReturn(cf);

    this.runTareaConsolidarByAmbitoService.run(new RunTareaDto());

    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoPersona(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoCalculoPersona(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoLocalizacion(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoLocalizacionPersona(any(RunTareaDto.class));

  }

  @Test
  void runExceptionTest() {
    doThrow(new RuntimeException("e")).when(this.runTareaConsolidarPeriodoAsyncService).mergePeriodoPersona(any(RunTareaDto.class));

    assertThrows(RuntimeException.class,
        () -> this.runTareaConsolidarByAmbitoService.run(new RunTareaDto()));
  }

}
