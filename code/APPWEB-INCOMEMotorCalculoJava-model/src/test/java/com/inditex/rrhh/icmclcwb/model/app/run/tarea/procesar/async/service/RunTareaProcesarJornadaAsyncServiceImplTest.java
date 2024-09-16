package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarJornadaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RunTareaProcesarJornadaAsyncServiceImplTest {

  @Mock
  private RunTareaProcesarJornadaService runTareaProcesarJornadaService;

  @InjectMocks
  private RunTareaProcesarJornadaAsyncServiceImpl runTareaProcesarJornadaAsyncService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("ProcesarJornadaLocalizacionPersona should complete successfully")
  void procesarJornadaLocalizacionPersonaShouldCompleteSuccessfully() throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    doNothing().when(this.runTareaProcesarJornadaService).procesarJornadaLocalizacionPersona(runTareaDto);

    final CompletableFuture<Void> future = this.runTareaProcesarJornadaAsyncService.procesarJornadaLocalizacionPersona(runTareaDto);

    assertEquals(CompletableFuture.completedFuture(null).get(), future.get());
    verify(this.runTareaProcesarJornadaService, times(1)).procesarJornadaLocalizacionPersona(runTareaDto);
  }

  @Test
  @DisplayName("ProcesarJornadaLocalizacion should complete successfully")
  void procesarJornadaLocalizacionShouldCompleteSuccessfully() throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    doNothing().when(this.runTareaProcesarJornadaService).procesarJornadaLocalizacion(runTareaDto);

    final CompletableFuture<Void> future = this.runTareaProcesarJornadaAsyncService.procesarJornadaLocalizacion(runTareaDto);

    assertEquals(CompletableFuture.completedFuture(null).get(), future.get());
    verify(this.runTareaProcesarJornadaService, times(1)).procesarJornadaLocalizacion(runTareaDto);
  }
}
