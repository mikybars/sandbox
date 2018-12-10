package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.decorator.TrabajoTiendaEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;

@Mapper
@DecoratedWith(TrabajoTiendaEstadoDecorator.class)
public abstract class TrabajoTiendaEstadoMapper {

	@Mapping(target = "idTrabajo", source = "trabajo.id")
	public abstract TrabajoTiendaEstadoDto trabajoTiendaEstadoToTrabajoTiendaEstadoDto(TrabajoTiendaEstado src);

	@InheritInverseConfiguration
	public abstract TrabajoTiendaEstado trabajoTiendaEstadoDtoToTrabajoTiendaEstado(TrabajoTiendaEstadoDto src);

	public abstract List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoToTrabajoTiendaEstadoDto(
			List<TrabajoTiendaEstado> src);

	public abstract List<TrabajoTiendaEstado> trabajoTiendaEstadoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> src);

	@Mapping(target = "trabajo.id", source = "srcTrabajoDto.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcTrabajoTiendaEstadoDto.idPais")
	@Mapping(target = "idEmpresa", source = "srcTrabajoTiendaEstadoDto.idEmpresa")
	public abstract TrabajoTiendaEstado mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			TrabajoTiendaEstadoDto srcTrabajoTiendaEstadoDto, TrabajoDto srcTrabajoDto);

	public List<TrabajoTiendaEstado> mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
			List<TrabajoTiendaEstadoDto> srcTrabajoTiendaEstadoDto, TrabajoDto srcTrabajoDto) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Mapping(target = "idPaisOrigen", source = "idOrigen")
	@Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
	@Mapping(target = "idPais", source = "idPais")
	@Mapping(target = "idEmpresa", source = "idEmpresa")
	@Mapping(target = "idCadena", source = "idCadena")
	@Mapping(target = "idTienda", source = "idTiendaMtu")
	public abstract TrabajoTiendaEstadoDto genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
			GenericTiendaResultItemDto src);

	public abstract List<TrabajoTiendaEstadoDto> genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
			List<GenericTiendaResultItemDto> src);

}