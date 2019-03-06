package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_TAREA_EMPLEADO")
@Data
public class EstadoTareaEmpleado {

	@Id
	@Column(name = "ID_ESTADO_TAREA_EMPLEADO")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

}