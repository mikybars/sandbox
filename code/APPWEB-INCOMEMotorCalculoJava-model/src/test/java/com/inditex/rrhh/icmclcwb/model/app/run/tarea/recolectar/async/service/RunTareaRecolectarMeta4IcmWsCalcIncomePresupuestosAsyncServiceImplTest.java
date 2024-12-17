package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService;

  @InjectMocks
  private RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncServiceImpl runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService;

  @Test
  void personaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.personaByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService, times(1)).personaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void localizacionByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.localizacionByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService, times(1)).localizacionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void empleadosPresenciaByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.empleadosPresenciaByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService, times(1)).empleadosPresenciaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void empleadosDesplazamientoByRunTareaTest() {
    this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosAsyncService.empleadosDesplazamientoByRunTarea(new RunTareaDto());
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService, times(1))
        .empleadosDesplazamientoByRunTarea(any(RunTareaDto.class));
  }
}
