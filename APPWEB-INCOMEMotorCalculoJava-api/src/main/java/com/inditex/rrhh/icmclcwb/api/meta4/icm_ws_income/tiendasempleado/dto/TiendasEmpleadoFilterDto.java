package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TiendasEmpleadoFilterDto implements Serializable {

	private static final long serialVersionUID = -6940616698243825058L;
	
	private LocalDateTime fechaFin;
	
	private String idOrigen;
	
	private String idEmpresa;

	private LocalDateTime fechaInicio;
	
	private List<TiendasEmpleadoFilterParametersDto> items;
}
