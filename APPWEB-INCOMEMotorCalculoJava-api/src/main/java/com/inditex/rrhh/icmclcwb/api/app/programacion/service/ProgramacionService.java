package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

public interface ProgramacionService {

    ProgramacionDto create(@Valid final ProgramacionDto programacion);

    ProgramacionDto modify(final ProgramacionDto programacion);

    LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDto programacion);

    List<ProgramacionDto> findPendiente();

    ProgramacionDto updateEjecucion(@Valid final ProgramacionDto programacion);

    void reset();

    void activa();

    void activa(@Positive @NotNull final Long id);

    void desactiva();

    void desactiva(@Positive @NotNull final Long id);

    ProgramacionDto findById(@Positive @NotNull final Long id);

    ProgramacionDto findPendienteById(@Positive @NotNull Long id);

}
