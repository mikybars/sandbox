package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_PROGRAMACION", schema = "DESARROLLO_RRHH")
@Data
public class Programacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROGRAMACION")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "HORA_PROGRAMACION", nullable = false)
	private String hora;
	
	@NotNull
	@Column(name = "HORA_PROGRAMACION_HUSO", nullable = false)
	private String huso;

	@NotNull
	@Column(name = "ACTIVA", nullable = false)
	private Boolean activa;

	@Column(name = "ID_ORIGEN", nullable = true)
	private String idOrigen;

	@Column(name = "ID_EMPRESA", nullable = true)
	private String idEmpresa;

//	@Column(name = "ID_TIENDA", nullable = true)
//	private String idTienda;

//	@OneToMany
//	@JoinTable(name = "INCOME_PROGRAMACION_TIENDA", schema = "DESARROLLO_RRHH", joinColumns = {
//			@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") }, inverseJoinColumns = {
//					@JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA") })
//	private List<Tienda> tiendas;

	@OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "programacion"/*, cascade = { CascadeType.ALL }*/)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION")
	private List<ProgramacionTienda> tiendas;

//	@Column(name = "ID_EMPLEADO", nullable = true)
//	private String idEmpleado;

//	@OneToMany
//	@JoinTable(name = "INCOME_PROGRAMACION_EMPLEADO", schema = "DESARROLLO_RRHH", joinColumns = {
//			@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") }, inverseJoinColumns = {
//					@JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO") })
//	private List<Empleado> empleados;

	@OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "programacion"/*, cascade = CascadeType.ALL*/)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION")
	private List<ProgramacionEmpleado> empleados;

	@NotBlank
	@Column(name = "ID_USUARIO", nullable = false)
	private String idUsuario;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "FECHA_ULTIMA_EJECUCION", nullable = true)
	private Date fechaUltimaEjecucion;

	@NotNull
	@Column(name = "FECHA_SIGUIENTE_EJECUCION", nullable = false)
	private Date fechaSiguienteEjecucion;

//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "INCOME_PROGRAMACION_TRABAJO", schema = "DESARROLLO_RRHH", joinColumns = {
//			@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") }, inverseJoinColumns = {
//					@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") })
//	private List<Trabajo> trabajo;

}