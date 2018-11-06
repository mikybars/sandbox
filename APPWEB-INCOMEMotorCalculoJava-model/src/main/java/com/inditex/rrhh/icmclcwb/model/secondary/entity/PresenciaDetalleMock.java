package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class PresenciaDetalleMock {
	
	private Integer tienda;
	private Integer seccion;
	private Integer persona;
	private Integer horas;
	private Date fecha;
	private Integer minutos;
	private Integer tipo;
	private Integer origen;
	private Boolean modificado_income;
	private Integer cadena;
}
