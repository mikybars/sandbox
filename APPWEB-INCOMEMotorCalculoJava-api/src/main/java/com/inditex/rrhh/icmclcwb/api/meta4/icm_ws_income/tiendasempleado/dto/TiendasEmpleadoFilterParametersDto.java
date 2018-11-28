package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendasempleado.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TiendasEmpleadoFilterParametersDto implements Serializable {
	
	private static final long serialVersionUID = -1376019181239309304L;
	
	private String idEmpleado;
	
	private String orEmpleado;
	
	private String idLugarTrabajo;

}
