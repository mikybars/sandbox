package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;

import lombok.Data;

@Data
public class TiposHorasMock {
	private Integer id;
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Integer horas;
	private Date fecha;
	private Integer tipoHora;
	private Integer Origen;
	private Boolean excluidoDenom;
	private Boolean excluidoCalculo;

}
