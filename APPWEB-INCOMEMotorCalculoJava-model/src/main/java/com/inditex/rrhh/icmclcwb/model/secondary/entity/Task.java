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
import javax.validation.constraints.NotNull;
import lombok.Data;

//@Entity
@Table(name = "TEST_INCOME_TASK")
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "ID_JOB", nullable = false)
	private /* BigInteger */ Long idJob;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO", nullable = true)
	private /* BigInteger */ TaskEstado estado;

	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

	@Column(name = "ID_TIENDA", nullable = true)
	private String idTienda;

	@Column(name = "ID_EMPLEADO", nullable = true)
	private String idEmpleado;

	@Column(name = "FECHA_INICIO_TASK", nullable = true)
	private Date fechaInicioTask;

	@Column(name = "FECHA_FIN_TASK", nullable = true)
	private Date fechaFinTask;

	@NotNull
	@Column(name = "FECHA_INICIO_PERIODO", nullable = false)
	private Date fechaInicioPeriodo;

	@NotNull
	@Column(name = "FECHA_FIN_PERIODO", nullable = false)
	private Date fechaFinPeriodo;

}