package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchempleados.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SearchEmpleadosFilterDto implements Serializable {

	private static final long serialVersionUID = -3560099527012366482L;

	private LocalDateTime fechaFin;
	
	private String idOrigen;
	
	private String idEmpresa;

	private LocalDateTime fechaInicio;
	
	private List<SearchEmpleadosFilterParametersDto> items;
}
