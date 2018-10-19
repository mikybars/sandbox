package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PresenciaTotalTiendaMock {
	private List<Integer> tienda;
	private Date fecha;

	private Integer seccion;

	private Integer persona;

	private Integer horas;
	
	private Integer tipo;
	
	private Integer origen;
}
