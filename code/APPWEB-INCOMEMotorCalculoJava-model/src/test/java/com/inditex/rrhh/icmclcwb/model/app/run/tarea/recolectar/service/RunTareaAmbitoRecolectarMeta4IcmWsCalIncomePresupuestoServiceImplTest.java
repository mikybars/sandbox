package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
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
class RunTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoServiceImplTest {
  @Mock
  private TareaLocalizacionPresupuestoService tareaLocalizacionPresupuestoService;

  @InjectMocks
  private RunTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoServiceImpl runTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoService;

  @Test
  void RunTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoServiceImplTest() {
    when(this.tareaLocalizacionPresupuestoService.findPresupuestos(any(TareaDto.class)))
        .thenReturn(new TareaLocalizacionPresupuestoListDto());
    this.runTareaAmbitoRecolectarMeta4IcmWsCalIncomePresupuestoService.getFechaInicioPeriodo(new TareaDto());
    verify(this.tareaLocalizacionPresupuestoService).findPresupuestos(any(TareaDto.class));

  }

}
