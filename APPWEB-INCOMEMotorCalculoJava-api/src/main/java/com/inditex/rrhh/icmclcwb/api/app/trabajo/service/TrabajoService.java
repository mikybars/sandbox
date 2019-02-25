package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;

public interface TrabajoService {

    TrabajoDto find(@NotNull @Positive final Long id);
    
    TrabajoDto create(@Valid final TrabajoDto trabajo);

    List<TrabajoDto> create(@Valid @NotNull final ProgramacionDto programacion, @Valid @NotNull final PeriodoDto periodo);

}