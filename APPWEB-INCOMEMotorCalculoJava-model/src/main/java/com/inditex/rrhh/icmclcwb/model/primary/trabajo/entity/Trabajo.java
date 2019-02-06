package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.inditex.rrhh.icmclcwb.model.primary.programacion.entity.Programacion;

import lombok.Data;

@Entity
@Table(name = "TRABAJO")
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
	@Column(name = "ID_ORIGEN", nullable = true)
	private String idPaisOrigen;

	@NotBlank
	@Column(name = "ID_EMPRESA", nullable = true)
	private String idEmpresa;

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
	@JoinTable(name = "PROGRAMACION_TRABAJO", joinColumns = {
			@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PROGRAMACION", referencedColumnName = "ID_PROGRAMACION") })
	private Programacion programacion;

}