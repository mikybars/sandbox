package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ProgramacionEmpleado;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ProgramacionEmpleadoMapper {

	ProgramacionEmpleadoDto programacionEmpleadoToProgramacionEmpleadoDto(ProgramacionEmpleado src);

	ProgramacionEmpleado programacionEmpleadoDtoToProgramacionEmpleado(ProgramacionEmpleadoDto src);

	List<ProgramacionEmpleadoDto> programacionEmpleadoToProgramacionEmpleadoDto(List<ProgramacionEmpleado> src);
	
	List<ProgramacionEmpleado> programacionEmpleadoDtoToProgramacionEmpleado(List<ProgramacionEmpleadoDto> src);

}