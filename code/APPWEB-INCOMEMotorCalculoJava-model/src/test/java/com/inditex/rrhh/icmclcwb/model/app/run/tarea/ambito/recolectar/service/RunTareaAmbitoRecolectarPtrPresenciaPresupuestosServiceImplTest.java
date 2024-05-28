package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoListDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoRecolectarPtrPresenciaPresupuestosServiceImplTest {
  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @InjectMocks
  private RunTareaAmbitoRecolectarPtrPresenciaPresupuestosServiceImpl runTareaAmbitoRecolectarPtrPresenciaPresupuestosService;

  @Test
  void getFechaInicioPeriodoTest() {
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(new TareaLocalizacionPresupuestoListDto());
    this.runTareaAmbitoRecolectarPtrPresenciaPresupuestosService.getFechaInicioPeriodo(new TareaDto());
    verify(this.tareaLocalizacionPresupuestoService, times(1)).findPresupuestos(any(TareaDto.class));
  }

}
