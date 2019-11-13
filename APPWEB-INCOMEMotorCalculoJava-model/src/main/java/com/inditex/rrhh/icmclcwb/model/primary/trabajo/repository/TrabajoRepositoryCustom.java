package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

import javax.validation.constraints.NotNull;

public interface TrabajoRepositoryCustom {

    void updateEstado(@NotNull final TrabajoDto trabajo, @NotNull final EstadoTrabajoDto estado);

    void updateFechaFin(@NotNull final TrabajoDto trabajo);

}
