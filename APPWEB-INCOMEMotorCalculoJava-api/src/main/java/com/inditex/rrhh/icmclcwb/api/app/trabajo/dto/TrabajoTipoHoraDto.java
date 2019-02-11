package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class TrabajoTipoHoraDto implements Serializable {

	private static final long serialVersionUID = 1164433898866141136L;

	@ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@NotBlank
	@ApiModelProperty(value = "Id de tipo de hora", required = true)
	private String idTipoHora;

	@NotNull
	@ApiModelProperty(value = "Flag comisionable", required = true)
	private Boolean comisionable;

	@NotNull
	@ApiModelProperty(value = "Trabajo", required = true)
	private Long idTrabajo;

}
