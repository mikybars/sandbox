package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PresenciasDetalleResponseDto implements Serializable{
	@NotNull
	private Integer tienda;
	private Integer seccion;
	@NotNull
	private Integer persona;
	@NotNull
	private Date fecha;
	private Integer minutos;
	private Integer tipo;
	private Integer cadena;
	private Boolean modificado_income;
}
