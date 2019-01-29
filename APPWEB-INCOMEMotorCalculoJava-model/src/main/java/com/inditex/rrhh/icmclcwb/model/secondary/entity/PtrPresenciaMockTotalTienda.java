package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;
import lombok.Data;

@Data
public class PtrPresenciaMockTotalTienda {

	private Integer tienda;

	private Date fecha;

	private Integer seccion;

	private Integer persona;

	private Integer horas;

	private Integer tipo;

	private Integer origen;

	private Integer minutos;

}