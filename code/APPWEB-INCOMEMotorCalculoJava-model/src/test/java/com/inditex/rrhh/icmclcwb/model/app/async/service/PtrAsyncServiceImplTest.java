package com.inditex.rrhh.icmclcwb.model.app.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class PtrAsyncServiceImplTest {
  @InjectMocks
  private PtrAsyncServiceImpl ptrAsyncServiceImpl;

  @Mock
  private PtrService ptrService;

  @Test
  void findPresenciasOrigenAndFechaTest()
      throws ExecutionException, InterruptedException {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    final PresenciaOrigenDto response = new PresenciaOrigenDto();

    when(this.ptrService.findPresenciasOrigenAndFecha(any(RunTareaDto.class), any(TareaAmbitoDto.class))).thenReturn(response);

    final CompletableFuture<PresenciaOrigenDto> cf =
        this.ptrAsyncServiceImpl.findPresenciasOrigenAndFecha(runTarea, tareaAmbito);

    assertEquals(response, cf.get());
  }

  @Test
  void findPresenciasOrigenAndFechaEsTest()
      throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();

    final PresenciaOrigenDto response = new PresenciaOrigenDto();

    when(this.ptrService.findPresenciasOrigenAndFechaEs(any(RunTareaDto.class), any(TareaAmbitoDto.class))).thenReturn(response);
    final CompletableFuture<PresenciaOrigenDto> cf = this.ptrAsyncServiceImpl.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbito);

    assertEquals(response, cf.get());

  }
}
