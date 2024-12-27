package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaProcesarCondicionesService {

  void updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea);

  void updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea);

  void updateActivoEstructuraTopes(@Valid final TareaDto tarea);

  void relacionarPresupuestosEstructurasSinDesplazamiento(@Valid final TareaDto tarea);

  void relacionarPresupuestosEstructurasDesplazamiento(@Valid @NonNull final TareaDto tarea);

  void desactivarChallengeOpcionOrigen(@Valid TareaDto tarea);

  void crearChallengeOpcionOrigen(@Valid TareaDto tarea);

  void desactivarManualOrdinalDoble(@Valid TareaDto tarea);

  void igualarBandasOrigenDestino(@Valid @NonNull final TareaDto tarea);

  void desactivarGlobalSeccionOpcionOrigen(@Valid TareaDto tarea);

  void crearGlobalSeccionOpcionOrigen(@Valid TareaDto tarea);

  void establecerBandaOpcionOrigen(@Valid @NonNull final TareaDto tarea);
}
