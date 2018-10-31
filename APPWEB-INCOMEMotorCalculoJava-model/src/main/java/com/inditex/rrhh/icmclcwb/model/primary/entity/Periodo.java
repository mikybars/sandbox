package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_POC_PERIODO", schema = "DESARROLLO_RRHH")
@Data
public class Periodo {

	@Id
	@Column(name = "ID_PERIODO")
	private String id;

	@NotNull
	@Column(name = "FECHA_INICIO_PERIODO", nullable = true)
	private Date fechaInicioPeriodo;

	@NotBlank
	@Column(name = "FECHA_FIN_PERIODO", nullable = true)
	private Date fechaFinPeriodo;

}