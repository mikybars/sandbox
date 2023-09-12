package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;

import javax.validation.constraints.NotNull;

public interface RunMantenimientoLimpiezaService {

  RunMantenimientoLimpiezaDTO run();

  RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id);

}
