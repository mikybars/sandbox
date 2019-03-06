package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaTiendaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaHistorico;

@Mapper
@DecoratedWith(TareaTiendaHistoricoDecorator.class)
public abstract class TareaTiendaHistoricoMapper {

	@Mapping(target = "idTarea", source = "tarea.id")
	public abstract TareaTiendaHistoricoDto tareaTiendaHistoricoToTareaTiendaHistoricoDto(TareaTiendaHistorico src);

	@InheritInverseConfiguration
	public abstract TareaTiendaHistorico tareaTiendaHistoricoDtoToTareaTiendaHistorico(TareaTiendaHistoricoDto src);

	public abstract List<TareaTiendaHistoricoDto> tareaTiendaHistoricoToTareaTiendaHistoricoDto(
			List<TareaTiendaHistorico> src);

	public abstract List<TareaTiendaHistorico> tareaTiendaHistoricoDtoToTareaTiendaHistorico(
			List<TareaTiendaHistoricoDto> src);
	
	@Mapping(target = "tarea.id", source = "srcTarea.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcTareaTiendaHistorico.idPais")
	@Mapping(target = "idEmpresa", source = "srcTareaTiendaHistorico.idEmpresa")
	public abstract TareaTiendaHistorico mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(
			TareaTiendaHistoricoDto srcTareaTiendaHistorico, TareaDto srcTarea);

	public List<TareaTiendaHistorico> mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(
			List<TareaTiendaHistoricoDto> srcTareaTiendaHistorico, TareaDto srcTareaDto) {
		throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
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
	public abstract TareaTiendaHistoricoDto genericTiendaResultItemDtoToTareaTiendaHistoricoDto(
			GenericTiendaResultItemDto src);

	public abstract List<TareaTiendaHistoricoDto> genericTiendaResultItemDtoToTareaTiendaHistoricoDto(
			List<GenericTiendaResultItemDto> src);

}