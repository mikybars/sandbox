package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PtrPresenciaDetalleComisionableResultItemDto {

	private Integer tienda;

	private Integer seccion;

	private Integer persona;

	private String fecha;

	private Integer minutos;

	private Integer tipo;

	private Integer cadena;
	
	private Integer empresa;
	
	private Integer origen;

	private List<SeccionPresenciasDetalleComisionableType> listaSeccion;

}