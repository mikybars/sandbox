package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;

import lombok.Data;

@Entity
@Table(name = "TAREA")
@Data
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA")
	private /* BigInteger */ Long id;

	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TAREA", nullable = false)
	private /* BigInteger */ EstadoTarea estado;

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

	@Column(name = "FECHA_INICIO_TAREA", nullable = true)
	private Date fechaInicioTarea;

	@Column(name = "FECHA_FIN_TAREA", nullable = true)
	private Date fechaFinTarea;

	@Column(name = "FECHA_INICIO_PERIODO", nullable = false)
	private Date fechaInicioPeriodo;

	@Column(name = "FECHA_FIN_PERIODO", nullable = false)
	private Date fechaFinPeriodo;

	@ManyToOne
	@JoinTable(name = "TRABAJO_TAREA", joinColumns = {
			@JoinColumn(name = "ID_TAREA", referencedColumnName = "ID_TAREA") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") })
	private Trabajo trabajo;

}