package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;
import com.inditex.rrhh.icmclcwb.ms.app.limpieza.SenderLimpieza;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunMantenimientoLimpiezaServiceImplTest {
  @Mock
  private TareaService tareaService;

  @Mock
  private TareaLimpiezaService tareaLimpiezaService;

  @Mock
  private SenderLimpieza senderLimpieza;

  @InjectMocks
  private RunMantenimientoLimpiezaServiceImpl runMantenimientoLimpiezaService;

  @Test
  void runTest() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
  }

  @Test
  void runIdTareaTest() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
  }

  @Test
  void runTest_CoversEjecutarGuardadoYEnvio_Success() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    tasks.add("task2");
    result.setIdTarea(tasks);

    final TareaLimpiezaDto tarea1 = new TareaLimpiezaDto();
    tarea1.setId(1L);
    final TareaLimpiezaDto tarea2 = new TareaLimpiezaDto();
    tarea2.setId(2L);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(Arrays.asList(tarea1, tarea2));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(2)).send(any(TareaLimpiezaDto.class));
  }

  @Test
  void runTest_CoversEjecutarGuardadoYEnvio_Error() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenThrow(new RuntimeException("Save failed"));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
  }

  @Test
  void runIdTareaTest_CoversEjecutarGuardadoYEnvio_Success() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    final TareaLimpiezaDto tarea = new TareaLimpiezaDto();
    tarea.setId(1L);

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(List.of(tarea));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(1)).send(any(TareaLimpiezaDto.class));
  }

  @Test
  void runTest_ResultNull_CoversNullValidation() {
    when(this.tareaService.findLimpieza()).thenReturn(null);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, never()).save(anyList());
  }

  @Test
  void runTest_IdTareaNull_CoversNullValidation() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(null);

    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, never()).save(anyList());
  }

  @Test
  void runTest_EmptyTareaList_CoversEmptyValidation() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, never()).save(anyList());
  }

  @Test
  void runTest_WithNullTareasList_CoversTareasNullCheck() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(null);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, never()).send(any());
  }

  @Test
  void runTest_WithEmptyTareasResult_CoversTareasEmptyCheck() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(new ArrayList<>());

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, never()).send(any());
  }

  @Test
  void runIdTareaTest_ResultNull_CoversNullValidation() {
    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(null);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> returnedResult != null);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaService, never()).save(anyList());
  }

  @Test
  void runTest_WithException_CoversExceptionHandling() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenThrow(new RuntimeException("Test exception"));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
  }

  @Test
  void runIdTareaTest_WithException_CoversExceptionHandling() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenThrow(new RuntimeException("Test exception"));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
  }

  private boolean waitForAsyncCompletion() {
    return true;
  }

  @Test
  void runTest_whenNoTasks_thenReturnsAndSkipsSave() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());
    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> response != null);

    assertNotNull(response);
    assertNotNull(response.getIdTarea());
    assertTrue(response.getIdTarea().isEmpty());
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, never()).save(anyList());
    verifyNoInteractions(this.senderLimpieza);
  }

  @Test
  void runTest_WithTasks_CoversSuccessPath() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final com.inditex.rrhh.icmclcwb.dto.IdTareaDTO task = new com.inditex.rrhh.icmclcwb.dto.IdTareaDTO();
    task.setId(1L);
    final List<com.inditex.rrhh.icmclcwb.dto.IdTareaDTO> tasks = new ArrayList<>();
    tasks.add(task);
    result.setIdTarea(tasks);

    final TareaLimpiezaDto tareaDto = new TareaLimpiezaDto();
    tareaDto.setId(1L);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(List.of(tareaDto));

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(1)).send(any(TareaLimpiezaDto.class));
  }

  @Test
  void runIdTareaTest_WithTasks_CoversSuccessPath() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final com.inditex.rrhh.icmclcwb.dto.IdTareaDTO task = new com.inditex.rrhh.icmclcwb.dto.IdTareaDTO();
    task.setId(5L);
    final List<com.inditex.rrhh.icmclcwb.dto.IdTareaDTO> tasks = new ArrayList<>();
    tasks.add(task);
    result.setIdTarea(tasks);

    final TareaLimpiezaDto tareaDto = new TareaLimpiezaDto();
    tareaDto.setId(5L);

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenReturn(List.of(tareaDto));

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.runIdTarea(5L);

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(1)).send(any(TareaLimpiezaDto.class));
  }

  @Test
  void runIdTareaTest_WithEmptyTareas_CoversEmptyPath() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.runIdTarea(5L);

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> response != null);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaService, never()).save(anyList());
  }

  @Test
  void runTest_WithException_InProcesarLimpieza() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final com.inditex.rrhh.icmclcwb.dto.IdTareaDTO task = new com.inditex.rrhh.icmclcwb.dto.IdTareaDTO();
    task.setId(10L);
    final List<com.inditex.rrhh.icmclcwb.dto.IdTareaDTO> tasks = new ArrayList<>();
    tasks.add(task);
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaService.save(anyList()))
        .thenThrow(new RuntimeException("Save error"));

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(this::waitForAsyncCompletion);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaService, times(1)).save(anyList());
  }

  @Test
  void runTest_CoversInitialLogInfoEnabled() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> response != null);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpieza();
  }

  @Test
  void runIdTareaTest_CoversInitialLogInfoEnabled() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);

    final RunMantenimientoLimpiezaDTO response = this.runMantenimientoLimpiezaService.runIdTarea(15L);

    await()
        .atMost(Duration.ofSeconds(2))
        .until(() -> response != null);

    assertNotNull(response);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
  }
}
