package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class ProgramacionEmpleadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador de la tienda", required = false)
	private String id;

	@ApiModelProperty(value = "Programación", required = false)
	private ProgramacionDto programacion;
	
	@NotBlank
	@ApiModelProperty(value = "Id del empleado", required = true)
	private String idEmpleado;

}