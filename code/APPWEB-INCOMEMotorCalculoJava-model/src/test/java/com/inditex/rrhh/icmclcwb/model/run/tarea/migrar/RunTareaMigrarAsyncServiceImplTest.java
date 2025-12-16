package com.inditex.rrhh.icmclcwb.model.run.tarea.migrar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.migrar.RunTareaMigrarAsyncServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaMigrarAsyncServiceImplTest {

  @Mock
  private TareaMigrarService tareaMigrarService;

  @InjectMocks
  private RunTareaMigrarAsyncServiceImpl runTareaMigrarAsyncServiceImpl;

  @Test
  void testMigrarListCalculoComision() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    doNothing().when(this.tareaMigrarService).migrarCalculoComision(runTareaDto, new ArrayList<>());

    final CompletableFuture<Void> result = this.runTareaMigrarAsyncServiceImpl.migrarListCalculoComision(runTareaDto, new ArrayList<>());

    verify(this.tareaMigrarService, times(1)).migrarCalculoComision(runTareaDto, new ArrayList<>());
    assertTrue(result.isDone());
  }

  @Test
  void testDeleteCalculoComisionByTareaActual() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    when(this.tareaMigrarService.deleteCalculoComisionByTareaActual(runTareaDto, tareaAmbitoDto)).thenReturn(new ArrayList<>());

    final CompletableFuture<Void> result =
        this.runTareaMigrarAsyncServiceImpl.deleteCalculoComisionByTareaActual(runTareaDto, tareaAmbitoDto);

    verify(this.tareaMigrarService, times(1)).deleteCalculoComisionByTareaActual(runTareaDto, tareaAmbitoDto);
    assertTrue(result.isDone());
  }
}
