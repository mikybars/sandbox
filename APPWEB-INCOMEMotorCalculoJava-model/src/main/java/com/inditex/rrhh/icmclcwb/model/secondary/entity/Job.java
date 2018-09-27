package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.util.Date;

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

//@Entity
@Table(name = "TEST_INCOME_JOB")
@Data
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO", nullable = true)
	private /* BigInteger */ JobEstado estado;

	@NotBlank
	@Column(name = "USUARIO", nullable = false)
	private String usuario;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "FECHA_INICIO_JOB", nullable = true)
	private Date fechaInicioJob;

	@Column(name = "FECHA_FIN_JOB", nullable = true)
	private Date fechaFinJob;

}