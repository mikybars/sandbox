package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEstado;

@Mapper
@DecoratedWith(TareaTiendaEstadoDecorator.class)
public abstract class TareaTiendaEstadoMapper {

	@Mapping(target = "idTarea", source = "tarea.id")
	public abstract TareaTiendaEstadoDto tareaTiendaEstadoToTareaTiendaEstadoDto(TareaTiendaEstado src);

	@InheritInverseConfiguration
	public abstract TareaTiendaEstado tareaTiendaEstadoDtoToTareaTiendaEstado(TareaTiendaEstadoDto src);

	public abstract List<TareaTiendaEstadoDto> tareaTiendaEstadoToTareaTiendaEstadoDto(
			List<TareaTiendaEstado> src);

	public abstract List<TareaTiendaEstado> tareaTiendaEstadoDtoToTareaTiendaEstado(
			List<TareaTiendaEstadoDto> src);

	@Mapping(target = "tarea.id", source = "srcTareaDto.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcTareaTiendaEstadoDto.idPais")
	@Mapping(target = "idEmpresa", source = "srcTareaTiendaEstadoDto.idEmpresa")
	public abstract TareaTiendaEstado mergeTareaTiendaEstadoDtoAndTareaDtoToTareaTiendaEstado(
			TareaTiendaEstadoDto srcTareaTiendaEstadoDto, TareaDto srcTareaDto);

	public List<TareaTiendaEstado> mergeTareaTiendaEstadoDtoAndTareaDtoToTareaTiendaEstado(
			List<TareaTiendaEstadoDto> tareaTiendaEstado, TareaDto tarea) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcGenericTiendaResultItem.idOrigen")
	@Mapping(target = "idTiendaMeta4", source = "srcGenericTiendaResultItem.idLugarTrabajo")
	@Mapping(target = "idPais", source = "srcGenericTiendaResultItem.idPais")
	@Mapping(target = "idEmpresa", source = "srcGenericTiendaResultItem.idEmpresa")
	@Mapping(target = "idCadena", source = "srcGenericTiendaResultItem.idCadena")
	@Mapping(target = "idTienda", source = "srcGenericTiendaResultItem.idTiendaMtu")
	@Mapping(target = "tipo.id", source = "srcTipoTareaTienda.id")
	public abstract TareaTiendaEstadoDto genericTiendaResultItemDtoToTareaTiendaEstadoDto(
			GenericTiendaResultItemDto srcGenericTiendaResultItem, TipoTareaTiendaDto srcTipoTareaTienda);

	public List<TareaTiendaEstadoDto> genericTiendaResultItemDtoToTareaTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoTareaTiendaDto srcTipoTareaTienda) {
		throw new UnsupportedOperationException("Not implemented");
	}

}
