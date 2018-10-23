package com.inditex.rrhh.icmclcwb.api.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TrabajoRunDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Trabajo", required = false)
	private TrabajoDto trabajo;

	@ApiModelProperty(value = "Resultado de la operación", required = false)
	private Boolean resultado;

}