package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


//@Entity
@Data
@Table(name = "TEST_INCOME_JOB")
public class PresenciaDetalleComisionableMock {
	
	private Integer estado;
	private Integer seccion;
	private Integer persona;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer tipo;
	private Integer cadena;
}
