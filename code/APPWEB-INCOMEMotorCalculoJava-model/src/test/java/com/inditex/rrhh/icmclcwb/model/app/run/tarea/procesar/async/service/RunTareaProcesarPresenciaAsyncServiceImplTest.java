package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaProcesarPresenciaAsyncServiceImplTest {
  @Mock
  private RunTareaProcesarPresenciaService runTareaProcesarPresenciaService;

  @InjectMocks
  private RunTareaProcesarPresenciaAsyncServiceImpl runTareaProcesarPresenciaAsyncService;

  @Test
  void compensarLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.compensarLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).compensarLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void totalizarLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void totalizarEcommerceLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarEcommerceLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarEcommerceLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void totalizarEmpleadosPorVentaTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarEmpleadosPorVenta(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarEmpleadosPorVenta(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionPersonaPresenciaTest() {
    this.runTareaProcesarPresenciaAsyncService.updateActivoLocalizacionPersonaPresencia(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).updateActivoLocalizacionPersonaPresencia(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionPersonaPresenciaVacioTest() {
    this.runTareaProcesarPresenciaAsyncService.updateActivoLocalizacionPersonaPresenciaVacio(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).updateActivoLocalizacionPersonaPresenciaVacio(any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionPersonaPresenciaTest() {
    this.runTareaProcesarPresenciaAsyncService.compensarLocalizacionPersonaPresencia(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).compensarLocalizacionPersonaPresencia(any(RunTareaDto.class));
  }

  @Test
  void compensarChallengeTest() {
    this.runTareaProcesarPresenciaAsyncService.compensarChallenge(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).compensarChallenge(any(RunTareaDto.class));
  }

  @Test
  void presenciasIncluidoVentaPersonaTest() {
    this.runTareaProcesarPresenciaAsyncService.presenciasIncluidoVentaPersona(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).presenciasIncluidoVentaPersona(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionVacioTest() {
    this.runTareaProcesarPresenciaAsyncService.updateActivoLocalizacionVacio(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).updateActivoLocalizacionVacio(any(RunTareaDto.class));
  }

  @Test
  void calcularPresenciasTotalesAgrupacionTest() {
    this.runTareaProcesarPresenciaAsyncService.calcularPresenciasTotalesAgrupacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).calcularPresenciasTotalesAgrupacion(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorPresencia(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorPresencia(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorPresenciaDesplazamiento(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorPresenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void presenciaDesplazamientoTest() {
    this.runTareaProcesarPresenciaAsyncService.presenciaDesplazamiento(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).presenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void presenciaDesplazamientoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaAsyncService.presenciaDesplazamientoChallengePorcentaje(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).presenciaDesplazamientoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorPresenciaDesplazamientoBase(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorPresenciaDesplazamientoBase(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1))
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaAsyncService
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1))
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasTest() {
    this.runTareaProcesarPresenciaAsyncService.presenciasHorasFijas(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).presenciasHorasFijas(any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasDesplazamientosTest() {
    this.runTareaProcesarPresenciaAsyncService.presenciasHorasFijasDesplazamientos(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).presenciasHorasFijasDesplazamientos(any(RunTareaDto.class));
  }

  @Test
  void indicadorPersonaPorVentaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorPersonaPorVenta(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorPersonaPorVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoDirectoVenta(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaSinPresenciasTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoDirectoVentaSinPresencias(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoDirectoVentaSinPresencias(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoBaseDirectoVenta(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoBaseDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamientoTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1))
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaOtraTiendaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoBaseDirectoVentaOtraTienda(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoBaseDirectoVentaOtraTienda(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaCambioFuncionTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoDirectoVentaCambioFuncion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoDirectoVentaCambioFuncion(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoChallengeImporteTiendaTest() {
    this.runTareaProcesarPresenciaAsyncService.indicadorDesplazamientoChallengeImporteTienda(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).indicadorDesplazamientoChallengeImporteTienda(any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionManualTest() {
    this.runTareaProcesarPresenciaAsyncService.compensarLocalizacionManual(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).compensarLocalizacionManual(any(RunTareaDto.class));
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.repartirPresenciasSindicalesLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).repartirPresenciasSindicalesLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionTest() {
    this.runTareaProcesarPresenciaAsyncService.repartirPresenciasSindicalesLocalizacionSeccion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).repartirPresenciasSindicalesLocalizacionSeccion(any(RunTareaDto.class));
  }

  @Test
  void totalizarEcommerceSeccionTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarEcommerceSeccion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarEcommerceSeccion(any(RunTareaDto.class));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarPresenciasSindicalesLocalizacion(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarPresenciasSindicalesLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void totalizarLocalizacionIncluidoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaAsyncService.totalizarLocalizacionIncluidoChallengePorcentaje(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).totalizarLocalizacionIncluidoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionIncluidoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaAsyncService.compensarLocalizacionIncluidoChallengePorcentaje(new RunTareaDto());
    verify(this.runTareaProcesarPresenciaService, times(1)).compensarLocalizacionManualIncluidoChallengePorcentaje(any(RunTareaDto.class));
  }

}
