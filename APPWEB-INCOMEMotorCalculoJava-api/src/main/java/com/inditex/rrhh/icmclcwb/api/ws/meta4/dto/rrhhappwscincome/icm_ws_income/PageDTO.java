package com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageDTO implements Serializable {
	
	private static final long serialVersionUID = 1951305116634110315L;

	private String tipoOrden;
	
	private String campoOrden;
	
	private String idBusqueda;
	
	private Integer numeroPagina;
	
	private Integer numeroTotalPaginas;
	
	private Integer numeroRegistrosPagina;
	
	private Integer numeroTotalResultados;

}