package com.inditex.rrhh.icmclcwb.model.primary.entity;

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
@Table(name = "INCOME_TRABAJO_EMPLEADO", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_EMPLEADO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TRABAJO_EMPLEADO", nullable = false)
	private /* BigInteger */ EstadoTrabajoEmpleado estado;
	
	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;

}