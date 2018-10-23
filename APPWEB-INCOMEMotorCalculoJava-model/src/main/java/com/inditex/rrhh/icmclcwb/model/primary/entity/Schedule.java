package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_PROGRAMACION", schema = "DESARROLLO_RRHH")
@Data
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROGRAMACION")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "HORA_PROGRAMACION", nullable = false)
	private LocalTime hora;

	@NotNull
	@Column(name = "ACTIVA", nullable = false)
	private Boolean activa;

	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

	@Column(name = "ID_TIENDA", nullable = true)
	private String idTienda;

	@Column(name = "ID_EMPLEADO", nullable = true)
	private String idEmpleado;

	@NotBlank
	@Column(name = "ID_USUARIO", nullable = false)
	private String idUsuario;

	@NotNull
	@Column(name = "PERIODO", nullable = false)
	private /* BigInteger */ Long periodo;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@NotNull
	@Column(name = "FECHA_SIGUIENTE_EJECUCION", nullable = false)
	private Date fechaSiguienteEjecucion;

	//@OneToMany
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "INCOME_PROGRAMACION_TRABAJO", schema = "DESARROLLO_RRHH", joinColumns = {
			@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO", unique = true) })
	private List<Job> jobs;

}