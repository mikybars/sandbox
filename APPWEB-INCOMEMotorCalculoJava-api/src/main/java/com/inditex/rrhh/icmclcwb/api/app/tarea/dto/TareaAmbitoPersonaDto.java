package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaAmbitoPersonaDto {

    @ApiModelProperty(value = "Identificador del ambito persona de la tarea", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id del origen", required = true, example = "11")
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true, example = "1000")
    private String idPersona;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true, example = "1")
    private String orPersona;

}
