package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PtrPresenciasTiendaSeccionDto {

	private Integer tienda;
	private Integer seccion;
	
}
