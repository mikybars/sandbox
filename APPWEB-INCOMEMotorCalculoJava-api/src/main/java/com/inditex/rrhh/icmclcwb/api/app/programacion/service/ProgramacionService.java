package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

public interface ProgramacionService {

	ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion);

	ProgramacionDto modifyProgramacion(@Valid final ProgramacionDto programacion);

	LocalDateTime fechaSiguienteEjecucion(@Valid ProgramacionDto programacion);

}