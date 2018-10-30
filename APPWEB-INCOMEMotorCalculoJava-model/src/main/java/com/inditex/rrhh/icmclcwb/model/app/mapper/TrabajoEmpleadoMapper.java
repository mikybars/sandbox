package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TrabajoEmpleadoMapper {

	TrabajoEmpleadoDto programacionEmpleadoToTrabajoEmpleadoDto(TrabajoEmpleado src);

	TrabajoEmpleado programacionEmpleadoDtoToTrabajoEmpleado(TrabajoEmpleadoDto src);
	
	@Mappings({ @Mapping(target = "id", ignore = true) })
	TrabajoEmpleadoDto programacionEmpleadoDtoToTrabajoEmpleadoDto(ProgramacionEmpleadoDto src);

}