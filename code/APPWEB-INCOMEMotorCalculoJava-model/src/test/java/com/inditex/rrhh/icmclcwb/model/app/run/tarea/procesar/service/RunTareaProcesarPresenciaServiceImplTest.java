package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaProcesarPresenciaServiceImplTest {

  @Mock
  private TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;

  @Mock
  private TareaLocalizacionPresenciaService tareaLocalizacionPresenciaService;

  @Mock
  private TareaAgrupacionPresenciaService tareaAgrupacionPresenciaService;

  @InjectMocks
  private RunTareaProcesarPresenciaServiceImpl runTareaProcesarPresenciaService;

  @Test
  void compensarLocalizacionTest() {
    this.runTareaProcesarPresenciaService.compensarLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).compensar(any(RunTareaDto.class));
  }

  @Test
  void totalizarLocalizacionTest() {
    this.runTareaProcesarPresenciaService.totalizarLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizar(any(RunTareaDto.class));
  }

  @Test
  void totalizarEcommerceLocalizacionTest() {
    this.runTareaProcesarPresenciaService.totalizarEcommerceLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizarEcommerce(any(RunTareaDto.class));
  }

  @Test
  void totalizarEmpleadosPorVentaTest() {
    this.runTareaProcesarPresenciaService.totalizarEmpleadosPorVenta(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizarEmpleadosPorVenta(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionVacioTest() {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionVacio(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).updateActivoVacio(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionPersonaPresenciaTest() {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresencia(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).updateActivo(any(RunTareaDto.class));
  }

  @Test
  void updateActivoLocalizacionPersonaPresenciaVacioTest() {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresenciaVacio(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).updateActivoVacio(any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionPersonaPresenciaTest() {
    this.runTareaProcesarPresenciaService.compensarLocalizacionPersonaPresencia(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).compensar(any(RunTareaDto.class));
  }

  @Test
  void compensarChallengeTest() {
    this.runTareaProcesarPresenciaService.compensarChallenge(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).compensarChallenge(any(RunTareaDto.class));
  }

  @Test
  void presenciasIncluidoVentaPersonaTest() {
    this.runTareaProcesarPresenciaService.presenciasIncluidoVentaPersona(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).presenciasIncluidoVenta(any(RunTareaDto.class));
  }

  @Test
  void calcularPresenciasTotalesAgrupacionTest() {
    final RunTareaDto tarea = new RunTareaDto();
    tarea.setTarea(new TareaDto());
    this.runTareaProcesarPresenciaService.calcularPresenciasTotalesAgrupacion(tarea);

    verify(this.tareaAgrupacionPresenciaService, times(1)).calcularPresenciasTotalesAgrupacion(any(TareaDto.class));
  }

  @Test
  void indicadorPresenciaTest() {
    this.runTareaProcesarPresenciaService.indicadorPresencia(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorPresencia(any(RunTareaDto.class));
  }

  @Test
  void presenciaDesplazamientoTest() {
    this.runTareaProcesarPresenciaService.presenciaDesplazamiento(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).presenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void presenciaDesplazamientoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaService.presenciaDesplazamientoChallengePorcentaje(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).presenciaDesplazamientoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoTest() {
    this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamiento(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorPresenciaDesplazamiento(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseTest() {
    this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamientoBase(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorPresenciaDesplazamientoBase(any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionTest() {
    this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
        any(RunTareaDto.class));
  }

  @Test
  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaService
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1))
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(
            any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasTest() {
    this.runTareaProcesarPresenciaService.presenciasHorasFijas(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).presenciasHorasFijas(any(RunTareaDto.class));
  }

  @Test
  void presenciasHorasFijasDesplazamientosTest() {
    this.runTareaProcesarPresenciaService.presenciasHorasFijasDesplazamientos(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).presenciasHorasFijasDesplazamientos(any(RunTareaDto.class));
  }

  @Test
  void indicadorPersonaPorVentaTest() {
    this.runTareaProcesarPresenciaService.indicadorPersonaPorVenta(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorPersonaPorVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVenta(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaSinPresenciasTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVentaSinPresencias(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoDirectoVentaSinPresencias(
        any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVenta(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoBaseDirectoVenta(any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamientoTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(
        any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoBaseDirectoVentaOtraTiendaTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVentaOtraTienda(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoBaseDirectoVentaOtraTienda(
        any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoDirectoVentaCambioFuncionTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVentaCambioFuncion(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoDirectoVentaCambioFuncion(
        any(RunTareaDto.class));
  }

  @Test
  void indicadorDesplazamientoChallengeImporteTiendaTest() {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoChallengeImporteTienda(new RunTareaDto());
    verify(this.tareaLocalizacionPersonaPresenciaService, times(1)).indicadorDesplazamientoChallengeImporteTienda(
        any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionManualTest() {
    this.runTareaProcesarPresenciaService.compensarLocalizacionManual(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).compensarLocalizacionManual(any(RunTareaDto.class));
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionTest() {
    this.runTareaProcesarPresenciaService.repartirPresenciasSindicalesLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).repartirPresenciasSindicalesLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void repartirPresenciasSindicalesLocalizacionSeccionTest() {
    this.runTareaProcesarPresenciaService.repartirPresenciasSindicalesLocalizacionSeccion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).repartirPresenciasSindicalesLocalizacionSeccion(any(RunTareaDto.class));
  }

  @Test
  void totalizarEcommerceSeccionTest() {
    this.runTareaProcesarPresenciaService.totalizarEcommerceSeccion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizarEcommerceSeccion(any(RunTareaDto.class));
  }

  @Test
  void totalizarPresenciasSindicalesLocalizacionTest() {
    this.runTareaProcesarPresenciaService.totalizarPresenciasSindicalesLocalizacion(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizarPresenciasSindicalesLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void totalizarLocalizacionIncluidoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaService.totalizarLocalizacionIncluidoChallengePorcentaje(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).totalizarIncluidoChallengePorcentaje(any(RunTareaDto.class));
  }

  @Test
  void compensarLocalizacionManualIncluidoChallengePorcentajeTest() {
    this.runTareaProcesarPresenciaService.compensarLocalizacionManualIncluidoChallengePorcentaje(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).compensarLocalizacionManualIncluidoChallengePorcentaje(
        any(RunTareaDto.class));
  }

  @Test
  void updateSindicalCerradaTest() {
    this.runTareaProcesarPresenciaService.updateSindicalCerrada(new RunTareaDto());
    verify(this.tareaLocalizacionPresenciaService, times(1)).updateSindicalCerrada(
        any(RunTareaDto.class));
  }

}
