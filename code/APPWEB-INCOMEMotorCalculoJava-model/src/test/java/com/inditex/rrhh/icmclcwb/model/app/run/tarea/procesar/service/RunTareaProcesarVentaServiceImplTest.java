package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePorVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaProcesarVentaServiceImplTest {

  @Mock
  private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

  @Mock
  private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

  @Mock
  private PrimaryTemporaryTablePorVentaRepositoryCustom primaryTemporaryTablePorVentaRepositoryCustom;

  @InjectMocks
  RunTareaProcesarVentaServiceImpl runTareaProcesarVentaService;

  @Test
  void totalizarVentaSinDevolucionPersonaLocalizacionTest(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarVentaSinDevolucionPersonaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1))
        .totalizarVentaSinDevolucionPersonaLocalizacion(runTarea.getTarea());
  }

  @Test
  void totalizarDevolucionPersonaLocalizacionTest(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionPersonaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).totalizarDevolucionPersonaLocalizacion(runTarea.getTarea());
  }

  @Test
  void totalizarDevolucionesVendedor0Test(@Random final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionesVendedor0(runTarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).totalizarDevolucionesVendedor0(runTarea.getTarea());
  }

  @Test
  void calcularImporteComisionVendedoresTest(@Random final RunTareaDto tarea) {

    this.runTareaProcesarVentaService.calcularImporteComisionVendedores(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).calcularImporteComisionVendedores(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @Test
  void calcularImporteComisionVendedoresExceptionTest(@Random final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempVentaFisicaLocalizacionSeccion();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.calcularImporteComisionVendedores(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, never()).calcularImporteComisionVendedores(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @Test
  void calcularImporteComisionVentaODevolucionTest(@Random final RunTareaDto tarea) {

    this.runTareaProcesarVentaService.calcularImporteComisionVentaODevolucion(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).calcularImporteComisionVentaODevolucion(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @Test
  void calcularImporteComisionVentaODevolucionExceptionTest(@Random final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempVentaFisicaLocalizacionSeccion();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.calcularImporteComisionVentaODevolucion(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempVentaFisicaLocalizacion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, never()).calcularImporteComisionVentaODevolucion(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @Test
  void devolucionImporte0Test(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaService.devolucionImporte0(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).indexTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempDatesEstructurasPorVenta(tarea.getTarea());
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).devolucionImporte0(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempDatesEstructurasPorVenta();
  }

  @Test
  void devolucionImporte0ExceptionTest(@Random final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempDatesEstructurasPorVenta();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.devolucionImporte0(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).indexTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempDatesEstructurasPorVenta(tarea.getTarea());
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, never()).devolucionImporte0(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempDatesEstructurasPorVenta();

  }

  @Test
  void totalizarDevolucionLocalizacion(@Random final RunTareaDto tarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionLocalizacion(tarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).totalizarDevolucionLocalizacion(tarea.getTarea());
  }

}
