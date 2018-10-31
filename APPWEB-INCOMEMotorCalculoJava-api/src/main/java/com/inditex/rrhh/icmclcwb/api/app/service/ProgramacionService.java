package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

public interface ProgramacionService {

	List<TrabajoDto> run();

	ProgramacionDto createProgramacion(@Valid ProgramacionDto programacion);
	
	ProgramacionDto modifyProgramacion(@Valid final ProgramacionDto programacion);

	Boolean init();

}