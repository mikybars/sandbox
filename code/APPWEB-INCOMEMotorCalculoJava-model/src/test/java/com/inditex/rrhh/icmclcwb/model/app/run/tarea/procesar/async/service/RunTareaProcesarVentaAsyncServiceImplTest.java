package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaProcesarVentaAsyncServiceImplTest {

  @Mock
  RunTareaProcesarVentaService tareaProcesarVentaService;

  @InjectMocks
  RunTareaProcesarVentaAsyncServiceImpl runTareaProcesarVentaAsyncService;

  @Test
  void totalizarVentaSinDevolucionPersonaLocalizacionTest(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
  }

  @Test
  void totalizarDevolucionPersonaLocalizacionTest(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionPersonaLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionPersonaLocalizacion(tarea);
  }

  @Test
  void totalizarDevolucionesVendedor0Test(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionesVendedor0(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionesVendedor0(tarea);
  }

  @Test
  void devolucionImporte0Test(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.devolucionImporte0(tarea);
    verify(this.tareaProcesarVentaService, times(1)).devolucionImporte0(tarea);
  }

  @Test
  void totalizarDevolucionLocalizacionTest(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionLocalizacion(tarea);
  }

}
