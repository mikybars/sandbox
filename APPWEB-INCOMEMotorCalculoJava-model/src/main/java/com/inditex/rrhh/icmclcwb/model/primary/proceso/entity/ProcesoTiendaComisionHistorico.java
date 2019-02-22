package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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
@Table(name = "PROCESO_TIENDA_COMISION_HISTORICO")
@Data
public class ProcesoTiendaComisionHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO_TIENDA_COMISION_HISTORICO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_PROCESO", nullable = false)
	private /* BigInteger */ Proceso proceso;

	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idTienda;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idTiendaMeta4;

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