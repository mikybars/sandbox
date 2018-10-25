package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class EmpleadoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador del empleado", required = false)
	private Long id;

	@NotBlank
	@ApiModelProperty(value = "Id del páis", required = false)
	private String idPais;

	@NotBlank
	@ApiModelProperty(value = "Id de la cadena", required = false)
	private String idCadena;

}