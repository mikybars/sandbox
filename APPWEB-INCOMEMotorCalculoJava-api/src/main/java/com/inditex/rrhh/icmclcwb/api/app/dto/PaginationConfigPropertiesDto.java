package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

@Data
public class PaginationConfigPropertiesDto {
	
	private Integer numeroPagina;
	private Integer numeroRegistrosPagina;
	private String tipoOrden;
	private String campoOrden;
	private String methodName;

}
