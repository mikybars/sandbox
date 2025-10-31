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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

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

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @InjectMocks
  private RunTareaValidacionesAgrupadasWrapper wrapper;

  @Test
  void executeShouldReturnEmptyListAndCallValidacionesNoBloqueantes() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(100L);
    runTarea.setTrabajo(trabajo);

    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(999L)
        .idTareaFase(10L)
        .build();

    doNothing().when(this.tareaFaseAccionService).updateFechaInicio(any(TareaFaseAccionDto.class));
    when(this.runValidacionesAgrupadasService
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class))).thenReturn(List.of());
    doNothing().when(this.tareaFaseAccionService).updateFechaFinAndEstado(any(TareaFaseAccionDto.class),
        any(EstadoTareaFaseAccionDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());
    assertNotNull(result.join());
    assertEquals(0, result.join().size());

    verify(this.tareaFaseAccionService, times(1)).updateFechaInicio(tareaFaseAccion);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
    verify(this.tareaFaseAccionService, times(1)).updateFechaFinAndEstado(eq(tareaFaseAccion), any(EstadoTareaFaseAccionDto.class));
  }

  @Test
  void executeShouldHandleDifferentTareaAndFase() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(200L);
    runTarea.setTrabajo(trabajo);

    final TareaDto tarea = new TareaDto();
    tarea.setId(100L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(888L)
        .idTareaFase(50L)
        .build();

    doNothing().when(this.tareaFaseAccionService).updateFechaInicio(any(TareaFaseAccionDto.class));
    when(this.runValidacionesAgrupadasService
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class))).thenReturn(List.of());
    doNothing().when(this.tareaFaseAccionService).updateFechaFinAndEstado(any(TareaFaseAccionDto.class),
        any(EstadoTareaFaseAccionDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());
    assertTrue(result.join().isEmpty());

    verify(this.tareaFaseAccionService, times(1)).updateFechaInicio(tareaFaseAccion);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
    verify(this.tareaFaseAccionService, times(1)).updateFechaFinAndEstado(eq(tareaFaseAccion), any(EstadoTareaFaseAccionDto.class));
  }

  @Test
  void executeShouldCreateCorrectFaseDto() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(300L);
    runTarea.setTrabajo(trabajo);

    final TareaDto tarea = new TareaDto();
    tarea.setId(25L);
    runTarea.setTarea(tarea);

    final TareaFaseAccionDto tareaFaseAccion = TareaFaseAccionDto.builder()
        .id(777L)
        .idTareaFase(4L)
        .build();

    doNothing().when(this.tareaFaseAccionService).updateFechaInicio(any(TareaFaseAccionDto.class));
    when(this.runValidacionesAgrupadasService
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class))).thenReturn(List.of());
    doNothing().when(this.tareaFaseAccionService).updateFechaFinAndEstado(any(TareaFaseAccionDto.class),
        any(EstadoTareaFaseAccionDto.class));

    final CompletableFuture<List<ValidacionDto>> result = this.wrapper.execute(runTarea, tareaFaseAccion);

    assertNotNull(result);
    assertTrue(result.isDone());

    verify(this.tareaFaseAccionService, times(1)).updateFechaInicio(tareaFaseAccion);
    verify(this.runValidacionesAgrupadasService, times(1))
        .ejecutarValidacionesNoBloqueantes(eq(runTarea), any(FaseDto.class));
    verify(this.tareaFaseAccionService, times(1)).updateFechaFinAndEstado(eq(tareaFaseAccion), any(EstadoTareaFaseAccionDto.class));
  }
}
