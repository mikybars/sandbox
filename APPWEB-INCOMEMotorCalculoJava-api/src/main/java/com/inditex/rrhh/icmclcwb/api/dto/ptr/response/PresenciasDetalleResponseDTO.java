package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PresenciasDetalleResponseDTO implements Serializable{
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer minutos;
	private Integer tipo;
	private Integer cadena; //Obligatorio	
	private Boolean modificado_income;

}
