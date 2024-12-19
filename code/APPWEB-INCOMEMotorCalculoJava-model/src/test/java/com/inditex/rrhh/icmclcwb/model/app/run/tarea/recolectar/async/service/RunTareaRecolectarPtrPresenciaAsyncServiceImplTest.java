package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrPresenciaAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarPtrPresenciaService tareaRecolectarPtrPresenciaService;

  @InjectMocks
  private RunTareaRecolectarPtrPresenciaAsyncServiceImpl runTareaRecolectarPtrPresenciaAsyncService;

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaTest() {
    this.runTareaRecolectarPtrPresenciaAsyncService.presenciaDetalleComisionablePersonaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrPresenciaService, times(1)).presenciaDetalleComisionablePersonaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presenciaEmpleadoTiendaByRunTareaTest() {
    this.runTareaRecolectarPtrPresenciaAsyncService.presenciaEmpleadoTiendaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrPresenciaService, times(1)).presenciaEmpleadoTiendaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presenciaDetallePersonaIncluidoCommerceByRunTareaTest() {
    this.runTareaRecolectarPtrPresenciaAsyncService.presenciaDetallePersonaIncluidoCommerceByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrPresenciaService, times(1)).presenciaDetalleIncluidoCommercePersonaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void presenciaDetallePersonaHorasSindicalesByRunTareaTest() {
    this.runTareaRecolectarPtrPresenciaAsyncService.presenciaDetallePersonaHorasSindicalesByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrPresenciaService, times(1)).presenciaDetallePersonaHorasSindicalesByRunTarea(any(RunTareaDto.class));
  }
}
