package com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;

public interface RunMantenimientoLimpiezaService {

    RunMantenimientoLimpiezaDTO run();

    RunMantenimientoLimpiezaDTO runIdTarea(@NotNull final Long id);

}
