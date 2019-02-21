package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;

public interface ProgramacionService {

	ProgramacionDto create(@Valid final ProgramacionDto programacion);

	ProgramacionDto modify(final ProgramacionDto programacion);

	LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDto programacion);
	
	List<ProgramacionDto> findPendiente();

}