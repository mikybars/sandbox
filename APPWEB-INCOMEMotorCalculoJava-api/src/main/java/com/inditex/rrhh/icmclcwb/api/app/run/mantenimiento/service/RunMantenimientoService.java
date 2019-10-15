package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;

public interface RunMantenimientoService {

    RunMantenimientoDto run();

    RunMantenimientoDto runIdTarea(@NotNull Long id);

}
