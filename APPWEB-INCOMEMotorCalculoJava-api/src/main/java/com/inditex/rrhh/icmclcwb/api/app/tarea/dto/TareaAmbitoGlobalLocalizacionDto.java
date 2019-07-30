package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionDto implements Serializable {

    private static final long serialVersionUID = 2149047890747327068L;

    @ApiModelProperty(value = "Identificador de la entidad", required = false)
	private String id;

	@NotNull
	@ApiModelProperty(value = "Identificador del tarea", required = true)
	private Long idTarea;

	@NotBlank
    @ApiModelProperty(value = "Identificador de la localizacion", required = true)
	private String stdIdWorkLocat;
	
    @NotBlank
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private String cclIdOrigen;

    @NotNull
    @ApiModelProperty(value = "Identificador de la empresa", required = true)
    private Long stdIdLegEnt;
}
