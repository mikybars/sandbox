package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoEmpleadoEstadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Trabajo", required = true)
	private TrabajoDto trabajo;
	
	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = true)
	private String idEmpleado;
	
	@NotNull
	@ApiModelProperty(value = "Estado del empleado en la operación", required = true)
	private EstadoTrabajoEmpleadoDto estado;

}