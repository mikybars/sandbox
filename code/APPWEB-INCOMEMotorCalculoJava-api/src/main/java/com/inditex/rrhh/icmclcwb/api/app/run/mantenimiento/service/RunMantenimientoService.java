package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;

import jakarta.validation.constraints.NotNull;

public interface RunMantenimientoService {

  RunMantenimientoDTO run();

  RunMantenimientoDTO runIdTarea(@NotNull Long id);

}
