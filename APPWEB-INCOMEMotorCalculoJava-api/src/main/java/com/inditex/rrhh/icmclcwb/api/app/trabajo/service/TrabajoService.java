package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

public interface TrabajoService {

    TrabajoDto find(@NotNull @Positive final Long id);

    TrabajoDTO create(@Valid @TrabajoValidator final TrabajoDTO trabajo);

    TrabajoDto merge(@Valid @NotNull final ProgramacionDTO programacion,
            @Valid @NotNull final ProgramacionAmbitoDTO programacionAmbito, @Valid @NotNull final PeriodoDTO periodo);

    void updateFechaFin(@NotNull final TrabajoDto trabajo);

    void updateEstado(@NotNull final TrabajoDto trabajo, @NotNull final EstadoTrabajoDto estado);

}
