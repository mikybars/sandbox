package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionTrabajoDto;

public interface ProgramacionService {

	List<ProgramacionTrabajoDto> run();

	ProgramacionDto createProgramacion(@Valid final ProgramacionDto programacion);

	Boolean init();

}