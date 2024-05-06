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
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaConsolidarByAmbitoLocalizacionServiceImplTest implements RunAlgoritmoTest {
  @Mock
  private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @InjectMocks
  private RunTareaConsolidarByAmbitoLocalizacionServiceImpl runTareaConsolidarByAmbitoLocalizacionService;

  @Test
  void runTest() {
    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoPersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoCalculoPersona(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacion(any(RunTareaDto.class))).thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.mergePeriodoLocalizacionPersona(any(RunTareaDto.class))).thenReturn(cf);
    this.runTareaConsolidarByAmbitoLocalizacionService.run(this.createRunTareaDto(1L, 2L));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoPersona(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoCalculoPersona(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoLocalizacion(any(RunTareaDto.class));
    verify(this.runTareaConsolidarPeriodoAsyncService, times(1)).mergePeriodoLocalizacionPersona(any(RunTareaDto.class));
  }

  @Test
  void runExceptionTest() {
    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);
    doThrow(new RuntimeException("e")).when(this.runTareaConsolidarPeriodoAsyncService).mergePeriodoPersona(any(RunTareaDto.class));
    doThrow(new RuntimeException("e")).when(this.runTareaConsolidarPeriodoAsyncService).mergePeriodoCalculoPersona(any(RunTareaDto.class));
    doThrow(new RuntimeException("e")).when(this.runTareaConsolidarPeriodoAsyncService).mergePeriodoLocalizacion(any(RunTareaDto.class));
    doThrow(new RuntimeException("e"))
        .when(this.runTareaConsolidarPeriodoAsyncService).mergePeriodoLocalizacionPersona(any(RunTareaDto.class));
    assertThrows(RuntimeException.class,
        () -> this.runTareaConsolidarByAmbitoLocalizacionService.run(this.createRunTareaDto(1344L, 2322L)));
  }
}
