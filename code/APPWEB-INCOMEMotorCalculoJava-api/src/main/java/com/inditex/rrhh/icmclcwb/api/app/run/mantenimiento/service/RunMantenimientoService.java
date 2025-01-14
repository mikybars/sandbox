package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;

import org.jspecify.annotations.NonNull;

public interface RunMantenimientoService {

  RunMantenimientoDTO run();

  RunMantenimientoDTO runIdTarea(@NonNull Long id);

}
