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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_TRABAJO_EMPLEADO_ESTRUCTURA", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoEmpleadoEstructura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_EMPLEADO_ESTRUCTURA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;
	
	@NotNull
	@Column(name = "ID_ESTRUCTURA", nullable = false)
	private /* BigInteger */ Long idEstructura;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_CALCULO", nullable = false)
	private /* BigInteger */ TipoCalculo tipoCalculo;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_COMISION", nullable = false)
	private /* BigInteger */ TipoComision tipoComision;
	
	@NotNull
	@Column(name = "ID_PORCENTAJE_1", nullable = false)
	private /* BigInteger */ Long porcentaje1;
	
	@NotNull
	@Column(name = "ID_PORCENTAJE_2", nullable = false)
	private /* BigInteger */ Long porcentaje2;
	
	@NotNull
	@Column(name = "ID_PORCENTAJE_3", nullable = false)
	private /* BigInteger */ Long porcentaje3;
	
	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fecha;

}