package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_EMPLEADO")
@Data
public class ProgramacionEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROGRAMACION_EMPLEADO")
	private /* BigInteger */ Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMACION", nullable = false)
	private /* BigInteger */ Programacion programacion;

	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;

	@NotNull
	@Column(name = "OR_EMPLEADO", nullable = false)
	private String orEmpleado;

}