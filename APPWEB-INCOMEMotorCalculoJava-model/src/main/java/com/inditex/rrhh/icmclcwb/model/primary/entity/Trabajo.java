package com.inditex.rrhh.icmclcwb.model.primary.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_TRABAJO", schema = "DESARROLLO_RRHH")
@Data
public class Trabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TRABAJO", nullable = false)
	private /* BigInteger */ EstadoTrabajo estado;

	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@Column(name = "ID_CADENA", nullable = true)
	private String idCadena;

//	@Column(name = "ID_TIENDA", nullable = true)
//	private String idTienda;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "INCOME_TRABAJO_TIENDA", schema = "DESARROLLO_RRHH", joinColumns = {
			@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA") })
	private List<Tienda> tienda;

//	@Column(name = "ID_EMPLEADO", nullable = true)
//	private String idEmpleado;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "INCOME_TRABAJO_EMPLEADO", schema = "DESARROLLO_RRHH", joinColumns = {
			@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO") })
	private List<Empleado> empleado;

	@NotBlank
	@Column(name = "ID_USUARIO", nullable = false)
	private String idUsuario;

	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "FECHA_INICIO_TRABAJO", nullable = true)
	private Date fechaInicioTrabajo;

	@Column(name = "FECHA_FIN_TRABAJO", nullable = true)
	private Date fechaFinTrabajo;

	@Column(name = "FECHA_INICIO_PERIODO", nullable = false)
	private Date fechaInicioPeriodo;

	@Column(name = "FECHA_FIN_PERIODO", nullable = false)
	private Date fechaFinPeriodo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "INCOME_PROGRAMACION_TRABAJO", schema = "DESARROLLO_RRHH", joinColumns = {
			@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION", unique = true) })
	private Programacion programacion;

}