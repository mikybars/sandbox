package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;
import lombok.Data;

@Data
public class PtrPresenciasMockDetalleComisionable {

	private Integer estado;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
}
