package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TipoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoTiendaEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaEstado;

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
			List<TrabajoTiendaEstadoDto> trabajoTiendaEstado, TrabajoDto trabajo) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcGenericTiendaResultItem.idOrigen")
	@Mapping(target = "idTiendaMeta4", source = "srcGenericTiendaResultItem.idLugarTrabajo")
	@Mapping(target = "idPais", source = "srcGenericTiendaResultItem.idPais")
	@Mapping(target = "idEmpresa", source = "srcGenericTiendaResultItem.idEmpresa")
	@Mapping(target = "idCadena", source = "srcGenericTiendaResultItem.idCadena")
	@Mapping(target = "idTienda", source = "srcGenericTiendaResultItem.idTiendaMtu")
	@Mapping(target = "tipo.id", source = "srcTipoTrabajoTienda.id")
	public abstract TrabajoTiendaEstadoDto genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
			GenericTiendaResultItemDto srcGenericTiendaResultItem, TipoTrabajoTiendaDto srcTipoTrabajoTienda);

	public List<TrabajoTiendaEstadoDto> genericTiendaResultItemDtoToTrabajoTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoTrabajoTiendaDto srcTipoTrabajoTienda) {
		throw new UnsupportedOperationException("Not implemented");
	}

}
