package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaProcesarPresenciaServiceImpl implements RunTareaProcesarPresenciaService {

  private final TareaLocalizacionPersonaPresenciaService tareaLocalizacionPersonaPresenciaService;

  private final TareaLocalizacionPresenciaService tareaLocalizacionPresenciaService;

  private final TareaAgrupacionPresenciaService tareaAgrupacionPresenciaService;

  @Override
  public void compensarLocalizacion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.compensar(runTarea);
  }

  @Override
  public void totalizarLocalizacion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.totalizar(runTarea);
  }

  @Override
  public void totalizarEcommerceLocalizacion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.totalizarEcommerce(runTarea);
  }

  @Override
  public void totalizarEmpleadosPorVenta(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.totalizarEmpleadosPorVenta(runTarea);
  }

  @Override
  public void updateActivoLocalizacionVacio(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.updateActivoVacio(runTarea);
  }

  @Override
  public void updateActivoLocalizacionPersonaPresencia(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.updateActivo(runTarea);
  }

  @Override
  public void updateActivoLocalizacionPersonaPresenciaVacio(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.updateActivoVacio(runTarea);
  }

  @Override
  public void compensarLocalizacionPersonaPresencia(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.compensar(runTarea);
  }

  @Override
  public void compensarChallenge(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.compensarChallenge(runTarea);
  }

  @Override
  public void presenciasIncluidoVentaPersona(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.presenciasIncluidoVenta(runTarea);
  }

  @Override
  public void calcularPresenciasTotalesAgrupacion(@Valid final RunTareaDto runTarea) {
    this.tareaAgrupacionPresenciaService.calcularPresenciasTotalesAgrupacion(runTarea.getTarea());
  }

  @Override
  public void indicadorPresencia(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorPresencia(runTarea);
  }

  @Override
  public void presenciaDesplazamiento(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.presenciaDesplazamiento(runTarea);
  }

  @Override
  public void presenciaDesplazamientoChallengePorcentaje(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.presenciaDesplazamientoChallengePorcentaje(runTarea);
  }

  @Override
  public void indicadorPresenciaDesplazamiento(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorPresenciaDesplazamiento(runTarea);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBase(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorPresenciaDesplazamientoBase(runTarea);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(runTarea);
  }

  @Override
  public void presenciasHorasFijas(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.presenciasHorasFijas(runTarea);
  }

  @Override
  public void presenciasHorasFijasDesplazamientos(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.presenciasHorasFijasDesplazamientos(runTarea);
  }

  @Override
  public void indicadorPersonaPorVenta(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorPersonaPorVenta(runTarea);
  }

  @Override
  public void indicadorDesplazamientoDirectoVenta(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoDirectoVenta(runTarea);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaSinPresencias(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoDirectoVentaSinPresencias(runTarea);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVenta(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoBaseDirectoVenta(runTarea);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(runTarea);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoBaseDirectoVentaOtraTienda(runTarea);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaCambioFuncion(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoDirectoVentaCambioFuncion(runTarea);
  }

  @Override
  public void indicadorDesplazamientoChallengeImporteTienda(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaPresenciaService.indicadorDesplazamientoChallengeImporteTienda(runTarea);
  }

  @Override
  public void compensarLocalizacionManual(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.compensarLocalizacionManual(runTarea);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacion(
      @Valid final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaService.repartirPresenciasSindicalesLocalizacion(runTareaDto);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacionSeccion(
      @Valid final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaService.repartirPresenciasSindicalesLocalizacionSeccion(runTareaDto);
  }

  @Override
  public void totalizarEcommerceSeccion(
      @Valid final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaService.totalizarEcommerceSeccion(runTareaDto);
  }

  @Override
  public void totalizarPresenciasSindicalesLocalizacion(
      @Valid final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaService.totalizarPresenciasSindicalesLocalizacion(runTareaDto);
  }

  @Override
  public void totalizarLocalizacionIncluidoChallengePorcentaje(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.totalizarIncluidoChallengePorcentaje(runTarea);
  }

  @Override
  public void compensarLocalizacionManualIncluidoChallengePorcentaje(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.compensarLocalizacionManualIncluidoChallengePorcentaje(runTarea);
  }

  @Override
  public void updateSindicalCerrada(@Valid final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaService.updateSindicalCerrada(runTarea);
  }

}
