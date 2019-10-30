package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;

public interface TrabajoService {

    TrabajoDto find(@NotNull @Positive final Long id);

    TrabajoDto create(@Valid @TrabajoValidator final TrabajoDto trabajo);

    TrabajoDto merge(@Valid @NotNull final ProgramacionDto programacion,
            @Valid @NotNull final ProgramacionAmbitoDto programacionAmbito, @Valid @NotNull final PeriodoDto periodo);

    void updateFechaFin(@NotNull final TrabajoDto trabajo);

    void updateEstado(@NotNull final TrabajoDto trabajo, @NotNull final EstadoTrabajoDto estado);

}
