package com.inditex.rrhh.icmclcwb.model.mapper;

import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaFilterDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.PageDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.IcmParametrostiendaBlock;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface IcmWsIncomeMapper {

	@Mappings({ @Mapping(source = "tipoorden", target = "tipoOrden"),
					@Mapping(source = "campoorden", target = "campoOrden"),
					@Mapping(source = "idbusqueda", target = "idBusqueda"),
					@Mapping(source = "numeropagina", target = "numeroPagina"),
					@Mapping(source = "numerototalpaginas", target = "numeroTotalPaginas"),
					@Mapping(source = "numeroregistrospagina", target = "numeroRegistrosPagina"),
					@Mapping(source = "numerototalresultados", target = "numeroTotalResultados") })
	PageDTO asPageDTO(IcmParametrospaginacionBlock src);

	@InheritInverseConfiguration
	// @Mappings({ @Mapping(source = "tipoOrden", target = "tipoorden"),
	// @Mapping(source = "campoOrden", target = "campoorden"),
	// @Mapping(source = "idBusqueda", target = "idbusqueda"),
	// @Mapping(source = "numeroPagina", target = "numeropagina"),
	// @Mapping(source = "numeroTotalPaginas", target = "numerototalpaginas"),
	// @Mapping(source = "numeroRegistrosPagina", target =
	// "numeroregistrospagina"),
	// @Mapping(source = "numeroTotalResultados", target =
	// "numerototalresultados") })
	IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDTO src);

	GetEmpleadosTiendaFilterDTO asGetEmpleadosTiendaFilterDTO(IcmParametrostiendaBlock src);

	IcmParametrostiendaBlock asIcmParametrostiendaBlock(GetEmpleadosTiendaFilterDTO src);

}