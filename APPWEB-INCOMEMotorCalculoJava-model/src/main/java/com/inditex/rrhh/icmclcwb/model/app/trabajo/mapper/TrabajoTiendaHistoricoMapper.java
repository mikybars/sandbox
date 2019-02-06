package com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.decorator.TrabajoTiendaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTiendaHistorico;

@Mapper
@DecoratedWith(TrabajoTiendaHistoricoDecorator.class)
public abstract class TrabajoTiendaHistoricoMapper {

	@Mapping(target = "idTrabajo", source = "trabajo.id")
	public abstract TrabajoTiendaHistoricoDto trabajoTiendaHistoricoToTrabajoTiendaHistoricoDto(TrabajoTiendaHistorico src);

	@InheritInverseConfiguration
	public abstract TrabajoTiendaHistorico trabajoTiendaHistoricoDtoToTrabajoTiendaHistorico(TrabajoTiendaHistoricoDto src);

	public abstract List<TrabajoTiendaHistoricoDto> trabajoTiendaHistoricoToTrabajoTiendaHistoricoDto(
			List<TrabajoTiendaHistorico> src);

	public abstract List<TrabajoTiendaHistorico> trabajoTiendaHistoricoDtoToTrabajoTiendaHistorico(
			List<TrabajoTiendaHistoricoDto> src);
	
	@Mapping(target = "trabajo.id", source = "srcTrabajo.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcTrabajoTiendaHistorico.idPais")
	@Mapping(target = "idEmpresa", source = "srcTrabajoTiendaHistorico.idEmpresa")
	public abstract TrabajoTiendaHistorico mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(
			TrabajoTiendaHistoricoDto srcTrabajoTiendaHistorico, TrabajoDto srcTrabajo);

	public List<TrabajoTiendaHistorico> mergeTrabajoTiendaHistoricoDtoAndTrabajoDtoToTrabajoTiendaHistorico(
			List<TrabajoTiendaHistoricoDto> srcTrabajoTiendaHistorico, TrabajoDto srcTrabajoDto) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	@Mapping(target = "idPais", source = "idPais")
	@Mapping(target = "idPaisOrigen", source = "idOrigen")
	@Mapping(target = "idEmpresa", source = "idEmpresa")
	@Mapping(target = "idCadena", source = "idCadena")
	@Mapping(target = "idTienda", source = "idTiendaMtu")
	@Mapping(target = "idTiendaMeta4", source = "idLugarTrabajo")
	@Mapping(target = "fechaInicio", source = "fechaInicio")
	@Mapping(target = "fechaFin", source = "fechaFin")
	@Mapping(target = "comisionable", source = "esComisionable")
	public abstract TrabajoTiendaHistoricoDto genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(
			GenericTiendaResultItemDto src);

	public abstract List<TrabajoTiendaHistoricoDto> genericTiendaResultItemDtoToTrabajoTiendaHistoricoDto(
			List<GenericTiendaResultItemDto> src);

}