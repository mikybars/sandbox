package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaValidacionesAgrupadasWrapperTest {

  @Mock
  private RunValidacionesAgrupadasService runValidacionesAgrupadasService;

  @Mock
  private TareaFaseService tareaFaseService;

  @InjectMocks
  private RunTareaValidacionesAgrupadasWrapper wrapper;

  @Test
  void executeShouldReturnEmptyListAndCallValidacionesNoBloqueantes() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .idTareaFase(10L)
        .build();

    final TareaFaseDto tareaFaseDto = TareaFaseDto.builder()
        .idFase(4)
        .build();

    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(1L, 4))
        .thenReturn(tareaFaseDto);
    doNothing().when(this.runValidacionesAgrupadasService)
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());
    assertNotNull(result.join());
    assertEquals(0, result.join().size());

    verify(this.tareaFaseService, times(1)).findTareaFaseDtoByIdTareaAndIdFase(1L, 4);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
  }

  @Test
  void executeShouldHandleDifferentTareaAndFase() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(100L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .idTareaFase(50L)
        .build();

    final TareaFaseDto tareaFaseDto = TareaFaseDto.builder()
        .idFase(4)
        .build();

    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(100L, 4))
        .thenReturn(tareaFaseDto);
    doNothing().when(this.runValidacionesAgrupadasService)
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());
    assertTrue(result.join().isEmpty());

    verify(this.tareaFaseService, times(1)).findTareaFaseDtoByIdTareaAndIdFase(100L, 4);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
  }

  @Test
  void executeShouldCreateCorrectFaseDto() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(25L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .idTareaFase(4L)
        .build();

    final TareaFaseDto tareaFaseDto = TareaFaseDto.builder()
        .idFase(4)
        .build();

    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(25L, 4))
        .thenReturn(tareaFaseDto);
    doNothing().when(this.runValidacionesAgrupadasService)
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());

    verify(this.tareaFaseService, times(1)).findTareaFaseDtoByIdTareaAndIdFase(25L, 4);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
  }
}
