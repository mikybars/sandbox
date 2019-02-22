package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

public class ProcesoTipoHoraDto implements Serializable {

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
	@ApiModelProperty(value = "Proceso", required = true)
	private Long idProceso;

}
