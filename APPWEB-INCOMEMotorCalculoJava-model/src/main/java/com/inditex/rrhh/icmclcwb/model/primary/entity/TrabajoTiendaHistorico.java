package com.inditex.rrhh.icmclcwb.model.primary.entity;

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

@Entity
@Table(name = "INCOME_TRABAJO_TIENDA_HISTORICO", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoTiendaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_TIENDA_HISTORICO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;

	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idTienda;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idTiendaMeta4;

	@NotBlank
	@Column(name = "STD_ID_COUNTRY", nullable = false)
	private String idPais;

	@NotBlank
	@Column(name = "CCL_ID_ORIGEN", nullable = false)
	private String idPaisOrigen;

	@NotBlank
	@Column(name = "STD_ID_LEG_ENT", nullable = false)
	private String idEmpresa;

	@NotBlank
	@Column(name = "CCL_ID_CADENA", nullable = false)
	private String idCadena;
	
	@NotNull
	@Column(name = "FECHA_INICIO", nullable = false)
	private Date fechaInicio;

	@NotNull
	@Column(name = "FECHA_FIN", nullable = false)
	private Date fechaFin;
	
	@NotNull
	@Column(name = "COMISIONABLE", nullable = false)
	private Boolean comisionable;

}