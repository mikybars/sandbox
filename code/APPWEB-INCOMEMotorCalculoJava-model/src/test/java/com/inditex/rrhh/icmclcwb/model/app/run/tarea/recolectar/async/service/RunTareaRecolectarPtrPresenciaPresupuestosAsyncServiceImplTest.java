package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaPresupuestosService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrPresenciaPresupuestosAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarPtrPresenciaPresupuestosService runTareaRecolectarPtrPresenciaPresupuestosService;

  @InjectMocks
  private RunTareaRecolectarPtrPresenciaPresupuestosAsyncServiceImpl runTareaRecolectarPtrPresenciaPresupuestosAsyncService;

  @Test
  void presenciaEmpleadoTiendaByRunTareaTest() {
    this.runTareaRecolectarPtrPresenciaPresupuestosAsyncService.presenciaEmpleadoTiendaByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarPtrPresenciaPresupuestosService, times(1)).presenciaEmpleadoTiendaByRunTarea(any(RunTareaDto.class));
  }
}
