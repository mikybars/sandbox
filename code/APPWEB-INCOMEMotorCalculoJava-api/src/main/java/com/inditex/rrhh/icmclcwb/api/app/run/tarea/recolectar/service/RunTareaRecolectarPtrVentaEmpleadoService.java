package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaRecolectarPtrVentaEmpleadoService {

  void ventaFisicaLocalizacionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
