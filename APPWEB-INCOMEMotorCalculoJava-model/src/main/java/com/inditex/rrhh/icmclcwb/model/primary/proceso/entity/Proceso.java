package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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
@Table(name = "PROCESO")
@Data
public class Proceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO")
	private /* BigInteger */ Long id;

	@OneToOne
	@JoinColumn(name = "ID_ESTADO_PROCESO", nullable = false)
	private /* BigInteger */ EstadoProceso estado;

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

	@Column(name = "FECHA_INICIO_PROCESO", nullable = true)
	private Date fechaInicioProceso;

	@Column(name = "FECHA_FIN_PROCESO", nullable = true)
	private Date fechaFinProceso;

	@Column(name = "FECHA_INICIO_PERIODO", nullable = false)
	private Date fechaInicioPeriodo;

	@Column(name = "FECHA_FIN_PERIODO", nullable = false)
	private Date fechaFinPeriodo;

	@ManyToOne
	@JoinTable(name = "TRABAJO_PROCESO", joinColumns = {
			@JoinColumn(name = "ID_PROCESO", referencedColumnName = "ID_PROCESO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_TRABAJO", referencedColumnName = "ID_TRABAJO") })
	private Trabajo trabajo;

}