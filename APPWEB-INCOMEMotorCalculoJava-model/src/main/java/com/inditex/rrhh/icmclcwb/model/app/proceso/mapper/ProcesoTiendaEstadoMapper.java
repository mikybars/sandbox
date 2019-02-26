package com.inditex.rrhh.icmclcwb.model.app.proceso.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.TipoProcesoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.decorator.ProcesoTiendaEstadoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTiendaEstado;

@Mapper
@DecoratedWith(ProcesoTiendaEstadoDecorator.class)
public abstract class ProcesoTiendaEstadoMapper {

	@Mapping(target = "idProceso", source = "proceso.id")
	public abstract ProcesoTiendaEstadoDto procesoTiendaEstadoToProcesoTiendaEstadoDto(ProcesoTiendaEstado src);

	@InheritInverseConfiguration
	public abstract ProcesoTiendaEstado procesoTiendaEstadoDtoToProcesoTiendaEstado(ProcesoTiendaEstadoDto src);

	public abstract List<ProcesoTiendaEstadoDto> procesoTiendaEstadoToProcesoTiendaEstadoDto(
			List<ProcesoTiendaEstado> src);

	public abstract List<ProcesoTiendaEstado> procesoTiendaEstadoDtoToProcesoTiendaEstado(
			List<ProcesoTiendaEstadoDto> src);

	@Mapping(target = "proceso.id", source = "srcProcesoDto.id")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcProcesoTiendaEstadoDto.idPais")
	@Mapping(target = "idEmpresa", source = "srcProcesoTiendaEstadoDto.idEmpresa")
	public abstract ProcesoTiendaEstado mergeProcesoTiendaEstadoDtoAndProcesoDtoToProcesoTiendaEstado(
			ProcesoTiendaEstadoDto srcProcesoTiendaEstadoDto, ProcesoDto srcProcesoDto);

	public List<ProcesoTiendaEstado> mergeProcesoTiendaEstadoDtoAndProcesoDtoToProcesoTiendaEstado(
			List<ProcesoTiendaEstadoDto> procesoTiendaEstado, ProcesoDto proceso) {
		throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
	}

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "idPaisOrigen", source = "srcGenericTiendaResultItem.idOrigen")
	@Mapping(target = "idTiendaMeta4", source = "srcGenericTiendaResultItem.idLugarTrabajo")
	@Mapping(target = "idPais", source = "srcGenericTiendaResultItem.idPais")
	@Mapping(target = "idEmpresa", source = "srcGenericTiendaResultItem.idEmpresa")
	@Mapping(target = "idCadena", source = "srcGenericTiendaResultItem.idCadena")
	@Mapping(target = "idTienda", source = "srcGenericTiendaResultItem.idTiendaMtu")
	@Mapping(target = "tipo.id", source = "srcTipoProcesoTienda.id")
	public abstract ProcesoTiendaEstadoDto genericTiendaResultItemDtoToProcesoTiendaEstadoDto(
			GenericTiendaResultItemDto srcGenericTiendaResultItem, TipoProcesoTiendaDto srcTipoProcesoTienda);

	public List<ProcesoTiendaEstadoDto> genericTiendaResultItemDtoToProcesoTiendaEstadoDto(
			List<GenericTiendaResultItemDto> srcGenericTiendaResultItem, TipoProcesoTiendaDto srcTipoProcesoTienda) {
		throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
	}

}
