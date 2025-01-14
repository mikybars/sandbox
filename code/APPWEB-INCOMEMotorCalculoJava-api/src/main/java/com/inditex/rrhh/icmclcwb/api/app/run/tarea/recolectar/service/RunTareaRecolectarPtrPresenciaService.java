package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarPtrPresenciaService {

  void presenciaDetalleComisionablePersonaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presenciaEmpleadoTiendaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presenciaDetalleIncluidoCommercePersonaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presenciaDetallePersonaHorasSindicalesByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

}
