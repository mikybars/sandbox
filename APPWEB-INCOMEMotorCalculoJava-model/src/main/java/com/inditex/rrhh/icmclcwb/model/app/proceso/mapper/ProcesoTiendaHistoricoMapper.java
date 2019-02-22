package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaHistoricoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaHistorico;

@Mapper
@DecoratedWith(ProcesoTiendaHistoricoDecorator.class)
public abstract class ProcesoTiendaHistoricoMapper {

	@Mapping(target = "idProceso", source = "proceso.id")
	public abstract ProcesoTiendaHistoricoDto procesoTiendaHistoricoToProcesoTiendaHistoricoDto(ProcesoTiendaHistorico src);

	@InheritInverseConfiguration
	public abstract ProcesoTiendaHistorico procesoTiendaHistoricoDtoToProcesoTiendaHistorico(ProcesoTiendaHistoricoDto src);

	public abstract List<ProcesoTiendaHistoricoDto> procesoTiendaHistoricoToProcesoTiendaHistoricoDto(
			List<ProcesoTiendaHistorico> src);

	public abstract List<ProcesoTiendaHistorico> procesoTiendaHistoricoDtoToProcesoTiendaHistorico(
			List<ProcesoTiendaHistoricoDto> src);
	
	@Mapping(target = "proceso.id", source = "srcProceso.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcProcesoTiendaHistorico.idPais")
	@Mapping(target = "idEmpresa", source = "srcProcesoTiendaHistorico.idEmpresa")
	public abstract ProcesoTiendaHistorico mergeProcesoTiendaHistoricoDtoAndProcesoDtoToProcesoTiendaHistorico(
			ProcesoTiendaHistoricoDto srcProcesoTiendaHistorico, ProcesoDto srcProceso);

	public List<ProcesoTiendaHistorico> mergeProcesoTiendaHistoricoDtoAndProcesoDtoToProcesoTiendaHistorico(
			List<ProcesoTiendaHistoricoDto> srcProcesoTiendaHistorico, ProcesoDto srcProcesoDto) {
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
	public abstract ProcesoTiendaHistoricoDto genericTiendaResultItemDtoToProcesoTiendaHistoricoDto(
			GenericTiendaResultItemDto src);

	public abstract List<ProcesoTiendaHistoricoDto> genericTiendaResultItemDtoToProcesoTiendaHistoricoDto(
			List<GenericTiendaResultItemDto> src);

}