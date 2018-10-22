package com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PresenciaTotalTiendaMock {
	private Integer Tienda;
	private Date Fecha;
	private Integer Seccion;

	private Integer Persona;

	private Integer Horas;
	
	private Integer Tipo;
	
	private Integer Origen;
	
	private Integer Minutos;
}
