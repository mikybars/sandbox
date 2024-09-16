package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaProcesarVentaAsyncServiceImplTest {

  @Mock
  RunTareaProcesarVentaService tareaProcesarVentaService;

  @InjectMocks
  RunTareaProcesarVentaAsyncServiceImpl runTareaProcesarVentaAsyncService;

  @ParameterizedTest
  @InstancioSource
  void totalizarVentaSinDevolucionPersonaLocalizacionTest(final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void totalizarDevolucionPersonaLocalizacionTest(final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionPersonaLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionPersonaLocalizacion(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void totalizarDevolucionesVendedor0Test(final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionesVendedor0(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionesVendedor0(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void devolucionImporte0Test(final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.devolucionImporte0(tarea);
    verify(this.tareaProcesarVentaService, times(1)).devolucionImporte0(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void totalizarDevolucionLocalizacionTest(final RunTareaDto tarea) {
    this.runTareaProcesarVentaAsyncService.totalizarDevolucionLocalizacion(tarea);
    verify(this.tareaProcesarVentaService, times(1)).totalizarDevolucionLocalizacion(tarea);
  }

}
