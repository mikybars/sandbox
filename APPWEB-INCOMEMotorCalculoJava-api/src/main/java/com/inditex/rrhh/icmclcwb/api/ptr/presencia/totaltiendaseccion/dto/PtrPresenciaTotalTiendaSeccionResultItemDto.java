package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;

import lombok.Data;

@Data
public class PtrPresenciaTotalTiendaSeccionResultItemDto {

	@NotNull
	private Integer tienda;

	private String fecha;

	private Integer seccion;
	
	private Integer empresa;

	private Integer minutos;
	
	private Integer origen;
	
	private List<PtrSeccionPresenciasGenericType> listaSeccion;
	
}