package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePorVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaProcesarVentaServiceImplTest {

  @Mock
  private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

  @Mock
  private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

  @Mock
  private PrimaryTemporaryTablePorVentaRepositoryCustom primaryTemporaryTablePorVentaRepositoryCustom;

  @InjectMocks
  RunTareaProcesarVentaServiceImpl runTareaProcesarVentaService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void totalizarVentaSinDevolucionPersonaLocalizacionTest(final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarVentaSinDevolucionPersonaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1))
        .totalizarVentaSinDevolucionPersonaLocalizacion(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void totalizarDevolucionPersonaLocalizacionTest(final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionPersonaLocalizacion(runTarea);
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).totalizarDevolucionPersonaLocalizacion(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void totalizarDevolucionesVendedor0Test(final RunTareaDto runTarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionesVendedor0(runTarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).totalizarDevolucionesVendedor0(runTarea.getTarea());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularImporteComisionVendedoresTest(final RunTareaDto tarea) {

    this.runTareaProcesarVentaService.calcularImporteComisionVendedores(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).calcularImporteComisionVendedores(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularImporteComisionVendedoresExceptionTest(final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempVentaFisicaLocalizacionSeccion();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.calcularImporteComisionVendedores(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, never()).calcularImporteComisionVendedores(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularImporteComisionVentaODevolucionTest(final RunTareaDto tarea) {

    this.runTareaProcesarVentaService.calcularImporteComisionVentaODevolucion(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempVentaFisicaLocalizacionSeccion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).calcularImporteComisionVentaODevolucion(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularImporteComisionVentaODevolucionExceptionTest(final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempVentaFisicaLocalizacionSeccion();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.calcularImporteComisionVentaODevolucion(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).createIndexTempVentaFisicaLocalizacionSeccion();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempVentaFisicaLocalizacion(tarea.getTarea());
    verify(this.tareaLocalizacionVentaRepositoryCustom, never()).calcularImporteComisionVentaODevolucion(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempVentaFisicaLocalizacionSeccion();

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void devolucionImporte0Test(final RunTareaDto tarea) {
    this.runTareaProcesarVentaService.devolucionImporte0(tarea);
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).indexTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).insertTempDatesEstructurasPorVenta(tarea.getTarea());
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1)).devolucionImporte0(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempDatesEstructurasPorVenta();
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void devolucionImporte0ExceptionTest(final RunTareaDto tarea) {

    doThrow(new RuntimeException("ERROR")).when(this.primaryTemporaryTablePorVentaRepositoryCustom)
        .createTempDatesEstructurasPorVenta();
    assertThrows(RuntimeException.class, () -> this.runTareaProcesarVentaService.devolucionImporte0(tarea));
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).createTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).indexTempDatesEstructurasPorVenta();
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, never()).insertTempDatesEstructurasPorVenta(tarea.getTarea());
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, never()).devolucionImporte0(tarea.getTarea());
    verify(this.primaryTemporaryTablePorVentaRepositoryCustom, times(1)).deleteTempDatesEstructurasPorVenta();

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void totalizarDevolucionLocalizacion(final RunTareaDto tarea) {
    this.runTareaProcesarVentaService.totalizarDevolucionLocalizacion(tarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).totalizarDevolucionLocalizacion(tarea.getTarea());
  }

}
