package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.limpieza.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLimpiezaAsyncService;
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
  void runTest() throws InterruptedException {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpieza()).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.run();

    Thread.sleep(200);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpieza();
  }

  @Test
  void runIdTareaTest() throws InterruptedException {
    final RunMantenimientoLimpiezaDTO result = new RunMantenimientoLimpiezaDTO();
    result.setIdTarea(new ArrayList<>());

    when(this.tareaService.findLimpiezaByIdTarea(any(Long.class))).thenReturn(result);

    final RunMantenimientoLimpiezaDTO returnedResult = this.runMantenimientoLimpiezaService.runIdTarea(1L);

    Thread.sleep(200);

    org.junit.jupiter.api.Assertions.assertNotNull(returnedResult);
    verify(this.tareaService, times(1)).findLimpiezaByIdTarea(any(Long.class));
  }
}
