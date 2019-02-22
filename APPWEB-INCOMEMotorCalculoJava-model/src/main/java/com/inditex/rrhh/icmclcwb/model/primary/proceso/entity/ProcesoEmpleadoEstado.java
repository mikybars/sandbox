package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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
@Table(name = "PROCESO_EMPLEADO_ESTADO")
@Data
public class ProcesoEmpleadoEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO_EMPLEADO_ESTADO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_PROCESO", nullable = false)
	private /* BigInteger */ Proceso proceso;
	
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
	@JoinColumn(name = "ID_ESTADO_PROCESO_EMPLEADO", nullable = false)
	private /* BigInteger */ EstadoProcesoEmpleado estado;

}