package com.inditex.rrhh.icmclcwb.model.app.mapper;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.entity.EstadoTrabajo;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
@DecoratedWith(TrabajoMapperDecorator.class)
public interface TrabajoMapper {

	TrabajoDto trabajoToTrabajoDto(Trabajo src);

	Trabajo trabajoDtoToTrabajo(TrabajoDto src);

	List<TrabajoDto> trabajosToTrabajosDto(List<Trabajo> src);

	@Mappings({ @Mapping(target = "id", ignore = true), @Mapping(source = "idPais", target = "idPais"),
			@Mapping(source = "idCadena", target = "idCadena"), @Mapping(source = "idTienda", target = "idTienda"),
			@Mapping(source = "idEmpleado", target = "idEmpleado"),
			@Mapping(source = "idUsuario", target = "idUsuario") })
	TrabajoDto programacionDtoToTrabajoDto(ProgramacionDto src);

	List<TrabajoDto> programacionDtosToTrabajoDtos(List<ProgramacionDto> src);

	EstadoTrabajoDto EstadoTrabajoToEstadoTrabajoDto(EstadoTrabajo src);

	EstadoTrabajo EstadoTrabajoDtoToEstadoTrabajo(EstadoTrabajoDto src);

}