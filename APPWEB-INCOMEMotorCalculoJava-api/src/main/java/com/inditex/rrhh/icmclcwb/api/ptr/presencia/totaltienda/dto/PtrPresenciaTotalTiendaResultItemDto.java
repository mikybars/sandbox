package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PtrPresenciaTotalTiendaResultItemDto {

	@NotNull
	private Integer tienda;

	private String fecha;

	@NotNull
	private Integer minutos;
	
	private Integer origen;

}