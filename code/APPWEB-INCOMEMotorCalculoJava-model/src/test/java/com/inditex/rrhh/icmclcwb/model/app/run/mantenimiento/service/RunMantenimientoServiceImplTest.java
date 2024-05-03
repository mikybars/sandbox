package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunMantenimientoServiceImplTest {
  @Mock
  private RunMantenimientoLimpiezaService runMantenimientoLimpiezaService;

  @InjectMocks
  private RunMantenimientoServiceImpl runMantenimientoService;

  @Test
  void runTest() {
    when(this.runMantenimientoLimpiezaService.run()).thenReturn(new RunMantenimientoLimpiezaDTO());
    this.runMantenimientoLimpiezaService.run();
    verify(this.runMantenimientoLimpiezaService, times(1)).run();
  }
}
