package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.dto.RunMantenimientoLimpiezaDto;

public interface RunMantenimientoLimpiezaService {

    RunMantenimientoLimpiezaDto run();

    RunMantenimientoLimpiezaDto runIdTarea(@NotNull Long id);

}
