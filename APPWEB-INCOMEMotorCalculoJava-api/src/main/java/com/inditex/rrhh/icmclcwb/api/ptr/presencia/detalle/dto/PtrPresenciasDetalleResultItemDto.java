package com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrPresenciasDetalleResultItemDto implements Serializable {

	private static final long serialVersionUID = -2286264737159679411L;

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