package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.searchtiendas.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SearchTiendasFilterDto implements Serializable {
	
	private static final long serialVersionUID = 8903951399908177954L;

	private LocalDateTime fechaFin;
	
	private String idOrigen;
	
	private String idEmpresa;

	private LocalDateTime fechaInicio;
	
	private List<SearchTiendasFilterParametersDto> items;
}
