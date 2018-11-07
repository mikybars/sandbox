package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.Data;

@Entity
@Table(name = "INCOME_TRABAJO", schema = "DESARROLLO_RRHH")
@Data
public class Trabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO")
	private /* BigInteger */ Long id;

	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TRABAJO", nullable = false)
	private /* BigInteger */ EstadoTrabajo estado;

	@NotBlank
	@Column(name = "ID_PAIS", nullable = true)
	private String idPais;

	@NotBlank
	@Column(name = "ID_EMPRESA", nullable = true)
	private String idEmpresa;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoTienda> tiendas;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoTiendaPresencia> tiendasPresencias;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoTiendaVenta> tiendasVentas;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoEmpleado> empleados;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoEmpleadoEstructura> empleadosEstructuras;

	@OneToMany(mappedBy = "trabajo")
	private List<TrabajoEmpleadoPresencia> empleadosPresencias;

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

	@ManyToOne
	@JoinTable(name = "INCOME_PROGRAMACION_TRABAJO", schema = "DESARROLLO_RRHH", joinColumns = {
			@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") })
	private Programacion programacion;

}