package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarPtrPresenciaService {

  void presenciaDetallePersonaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

}
