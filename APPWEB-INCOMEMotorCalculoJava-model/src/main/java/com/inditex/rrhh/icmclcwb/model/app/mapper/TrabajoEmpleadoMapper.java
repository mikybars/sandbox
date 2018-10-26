package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import org.mapstruct.Mapper;

@Mapper
public interface TrabajoEmpleadoMapper {

	TrabajoEmpleadoDto programacionEmpleadoToTrabajoEmpleadoDto(TrabajoEmpleado src);

	TrabajoEmpleado programacionEmpleadoDtoToTrabajoEmpleado(TrabajoEmpleadoDto src);

}