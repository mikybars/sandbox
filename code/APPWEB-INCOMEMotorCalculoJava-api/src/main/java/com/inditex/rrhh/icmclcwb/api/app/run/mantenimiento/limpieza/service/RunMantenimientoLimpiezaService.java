package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;

import org.jspecify.annotations.NonNull;

public interface RunMantenimientoLimpiezaService {

  RunMantenimientoLimpiezaDTO run();

  RunMantenimientoLimpiezaDTO runIdTarea(@NonNull final Long id);

}
