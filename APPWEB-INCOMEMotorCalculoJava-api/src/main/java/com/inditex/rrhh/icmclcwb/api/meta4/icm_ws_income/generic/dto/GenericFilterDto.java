package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.generic.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GenericFilterDto implements Serializable {

	private static final long serialVersionUID = -1018169475843699177L;
	
	private LocalDateTime fechaInicio;
	
    private LocalDateTime fechaFin;

	private String idOrigen;
	
	private String idEmpresa;
	
	private List<GenericFilterParametersDto> item = new ArrayList<>();
	
}
