package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.EmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Empleado;

import org.mapstruct.Mapper;

@Mapper
public interface EmpleadoMapper {

	EmpleadoDto EmpleadoToEmpleadoDto(Empleado src);

	Empleado EmpleadoDtoToEmpleado(EmpleadoDto src);

}