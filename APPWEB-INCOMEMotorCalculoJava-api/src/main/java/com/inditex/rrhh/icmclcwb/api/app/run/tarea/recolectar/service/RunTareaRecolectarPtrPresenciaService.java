package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaRecolectarPtrPresenciaService {

  void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void presenciaDetalleIncluidoCommercePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void presenciaDetallePersonaHorasSindicalesByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
