package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarEstructurasService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarValidarEstructurasAsyncServiceImpltTest {
  @Mock
  private RunTareaRecolectarValidarEstructurasService runTareaRecolectarValidarEstructurasService;

  @InjectMocks
  private RunTareaRecolectarValidarEstructurasAsyncServiceImpl runTareaRecolectarValidarEstructurasAsyncService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);
    final List<RunTareaValidarDto> lista = new ArrayList<>();

    when(this.runTareaRecolectarValidarEstructurasService.run(any(RunTareaDto.class))).thenReturn(lista);

    this.runTareaRecolectarValidarEstructurasAsyncService.run(runTarea);

    verify(this.runTareaRecolectarValidarEstructurasService).run(any(RunTareaDto.class));
  }
}
