package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.ProgramacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Programacion;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
@DecoratedWith(ProgramacionMapperDecorator.class)
public interface ProgramacionMapper {

	@Mappings({ @Mapping(target = "tiendas", ignore = true), @Mapping(target = "empleados", ignore = true) })
	ProgramacionDto programacionToProgracionDto(Programacion src);

	Programacion programacionDtoToProgramacion(ProgramacionDto src);

	List<ProgramacionDto> programacionToProgramacionDto(List<Programacion> src);

	ProgramacionDto programacionDtoToProgracionDtoId(ProgramacionDto src);

	Programacion programacionToProgracionId(Programacion src);

}