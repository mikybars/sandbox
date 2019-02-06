package com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_TRABAJO_EMPLEADO")
@Data
public class EstadoTrabajoEmpleado {

	@Id
	@Column(name = "ID_ESTADO_TRABAJO_EMPLEADO")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

}