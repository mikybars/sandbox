package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRepositoryCustom {

    void updateEstado(@NotNull final TrabajoDto trabajo, @NotNull final EstadoTrabajoDto estado);

    void updateFechaFin(@NotNull final TrabajoDto trabajo);

}
