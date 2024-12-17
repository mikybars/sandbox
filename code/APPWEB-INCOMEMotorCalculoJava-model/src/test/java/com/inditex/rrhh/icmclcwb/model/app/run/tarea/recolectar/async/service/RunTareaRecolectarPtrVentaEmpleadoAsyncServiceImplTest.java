package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaEmpleadoAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarPtrVentaEmpleadoService tareaRecolectarPtrVentaEmpleadoService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaEmpleadoAsyncServiceImpl runTareaRecolectarPtrVentaEmpleadoAsyncService;

  @Test
  void ventaOnlineIpodLocalizacionPersonaByRunTarea() {
    this.runTareaRecolectarPtrVentaEmpleadoAsyncService.ventaOnlineIpodLocalizacionPersonaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEmpleadoService).ventaFisicaLocalizacionPersonaByRunTarea(any(RunTareaDto.class));
  }
}
