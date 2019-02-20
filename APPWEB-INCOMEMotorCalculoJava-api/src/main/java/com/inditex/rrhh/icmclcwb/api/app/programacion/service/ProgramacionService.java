package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

public interface ProgramacionService {

	ProgramacionDto create(@Valid final ProgramacionDto programacion);

	ProgramacionDto modify(@Valid final ProgramacionDto programacion);

	LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDto programacion);

}