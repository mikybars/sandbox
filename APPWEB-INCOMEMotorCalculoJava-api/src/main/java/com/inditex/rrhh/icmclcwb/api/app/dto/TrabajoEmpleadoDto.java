package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoEmpleadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador", required = false)
	private String id;

	@NotBlank
	@ApiModelProperty(value = "Trabajo", required = false)
	private TrabajoDto trabajo;
	
	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = false)
	private String idEmpleado;

}