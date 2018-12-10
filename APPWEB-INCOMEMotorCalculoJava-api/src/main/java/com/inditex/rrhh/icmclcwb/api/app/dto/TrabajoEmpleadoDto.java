package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TrabajoEmpleadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ToString.Exclude
	@ApiModelProperty(value = "Identificador", required = false)
	private String id;

	@ToString.Exclude
	@NotNull
	@ApiModelProperty(value = "Trabajo", required = true)
	private Long idTrabajo;
	
	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = true, example = "1000")
	private String idEmpleado;
	
	@NotBlank
	@ApiModelProperty(value = "Ordinal del empleado", required = true, example = "1")
	private String orEmpleado;

}