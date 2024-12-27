package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarPtrVentaEmpleadoService {

  void ventaFisicaLocalizacionPersonaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

}
