package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;

public interface RunTareaProcesarPresenciaService {

  void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

  void compensarLocalizacion(@Valid RunTareaDto runTarea);

  void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

  void presenciasIncluidoVentaPersona(@Valid RunTareaDto runTarea);

  void totalizarLocalizacion(@Valid RunTareaDto runTarea);

  void calcularPresenciasTotalesAgrupacion(@Valid RunTareaDto runTarea);

  void updateActivoLocalizacionVacio(@Valid RunTareaDto runTarea);

  void updateActivoLocalizacionPersonaPresenciaVacio(@Valid RunTareaDto runTarea);

  void indicadorPresencia(@Valid RunTareaDto runTarea);

  void indicadorPresenciaDesplazamiento(@Valid RunTareaDto runTarea);

  void indicadorPresenciaDesplazamientoBase(@Valid RunTareaDto runTarea);

  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@Valid RunTareaDto runTarea);

  void totalizarEcommerceLocalizacion(@Valid RunTareaDto runTarea);

  void totalizarEmpleadosPorVenta(@Valid RunTareaDto runTarea);

  void presenciasHorasFijas(@Valid RunTareaDto runTarea);

  void presenciasHorasFijasDesplazamientos(@Valid RunTareaDto runTarea);

  void indicadorPersonaPorVenta(@Valid RunTareaDto runTarea);

  void compensarChallenge(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoDirectoVenta(@Valid RunTareaDto runTarea);

  void compensarLocalizacionManual(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoBaseDirectoVenta(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoDirectoVentaSinPresencias(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@Valid RunTareaDto runTarea);

  void indicadorDesplazamientoDirectoVentaCambioFuncion(@Valid RunTareaDto runTarea);

  void repartirPresenciasSindicalesLocalizacion(@Valid RunTareaDto runTareaDto);

  void repartirPresenciasSindicalesLocalizacionSeccion(@Valid RunTareaDto runTareaDto);

  void totalizarEcommerceSeccion(@Valid RunTareaDto runTareaDto);

  void totalizarPresenciasSindicalesLocalizacion(@Valid RunTareaDto runTareaDto);

  void indicadorDesplazamientoChallengeImporteTienda(@Valid RunTareaDto runTarea);

  void totalizarLocalizacionIncluidoChallengePorcentaje(@Valid RunTareaDto runTarea);

  void compensarLocalizacionManualIncluidoChallengePorcentaje(@Valid RunTareaDto runTarea);
}
