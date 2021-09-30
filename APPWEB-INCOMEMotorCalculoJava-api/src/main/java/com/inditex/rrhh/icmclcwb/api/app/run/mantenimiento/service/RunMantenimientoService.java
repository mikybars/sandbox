package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;

public interface RunMantenimientoService {

    RunMantenimientoDTO run();

    RunMantenimientoDTO runIdTarea(@NotNull Long id);

}
