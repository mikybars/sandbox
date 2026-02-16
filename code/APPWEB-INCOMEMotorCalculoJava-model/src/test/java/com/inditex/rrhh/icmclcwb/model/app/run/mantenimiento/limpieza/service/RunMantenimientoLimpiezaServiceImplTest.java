package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
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
  private TareaLimpiezaAsyncService tareaLimpiezaAsyncService;

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
    when(this.tareaLimpiezaAsyncService.save(anyList()))
        .thenReturn(CompletableFuture.completedFuture(Arrays.asList(tarea1, tarea2)));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(() -> {
          try {
            Thread.sleep(100);
            return true;
          } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
          }
        });

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaAsyncService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(2)).send(any(TareaLimpiezaDto.class));
  }

  @Test
  void runTest_CoversEjecutarGuardadoYEnvio_Error() {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    final List tasks = new ArrayList();
    tasks.add("task1");
    result.setIdTarea(tasks);

    when(this.tareaService.findLimpieza()).thenReturn(result);
    when(this.tareaLimpiezaAsyncService.save(anyList()))
        .thenReturn(CompletableFuture.failedFuture(new RuntimeException("Save failed")));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(() -> {
          try {
            Thread.sleep(100);
            return true;
          } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
          }
        });

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
    verify(this.tareaLimpiezaAsyncService, times(1)).save(anyList());
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
    when(this.tareaLimpiezaAsyncService.save(anyList()))
        .thenReturn(CompletableFuture.completedFuture(List.of(tarea)));

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    await()
        .atMost(Duration.ofSeconds(5))
        .pollInterval(Duration.ofMillis(100))
        .until(() -> {
          try {
            Thread.sleep(100);
            return true;
          } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
          }
        });

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
    verify(this.tareaLimpiezaAsyncService, times(1)).save(anyList());
    verify(this.senderLimpieza, times(1)).send(any(TareaLimpiezaDto.class));
  }
}
