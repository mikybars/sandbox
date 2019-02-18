package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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
@Table(name = "TAREA_EMPLEADO_ESTADO")
@Data
public class TareaEmpleadoEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_EMPLEADO_ESTADO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private /* BigInteger */ Tarea tarea;
	
	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;
	
	@NotNull
	@Column(name = "OR_EMPLEADO", nullable = false)
	private String orEmpleado;
	
	@NotNull
	@Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
	private String idEmpleadoLocal;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TAREA_EMPLEADO", nullable = false)
	private /* BigInteger */ EstadoTareaEmpleado estado;

}