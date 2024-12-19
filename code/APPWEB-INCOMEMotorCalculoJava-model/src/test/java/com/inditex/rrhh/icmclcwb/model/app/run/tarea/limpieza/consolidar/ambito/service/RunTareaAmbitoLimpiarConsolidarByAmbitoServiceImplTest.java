package com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpieza.consolidar.ambito.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpiar.consolidar.ambito.service.RunTareaAmbitoLimpiarConsolidarByAmbitoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoLimpiarConsolidarByAmbitoServiceImplTest {
  @Mock
  private RunTareaConsolidarPeriodoAsyncService runTareaConsolidarPeriodoAsyncService;

  @InjectMocks
  private RunTareaAmbitoLimpiarConsolidarByAmbitoServiceImpl runTareaAmbitoLimpiarConsolidarByAmbitoService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    runTarea.setTarea(tarea);
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbitoDto);

    final CompletableFuture cf = new CompletableFuture<>();
    cf.complete(null);

    when(this.runTareaConsolidarPeriodoAsyncService.limpiezaPeriodoPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.limpiezaPeriodoCalculoPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.limpiezaPeriodoLocalizacion(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);
    when(this.runTareaConsolidarPeriodoAsyncService.limpiezaPeriodoLocalizacionPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoLimpiarConsolidarByAmbitoService.run(runTarea, tareaAmbitoDto);

    assertEquals(cf, this.runTareaConsolidarPeriodoAsyncService.limpiezaPeriodoPersona(runTarea, tareaAmbitoDto));

  }

  @Test
  void runExceptionTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    runTarea.setTarea(tarea);
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbitoDto);

    doThrow(new RuntimeException())
        .when(this.runTareaConsolidarPeriodoAsyncService).limpiezaPeriodoPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class));
    assertThrows(RuntimeException.class, () -> this.runTareaAmbitoLimpiarConsolidarByAmbitoService.run(runTarea, tareaAmbitoDto));
  }
}
