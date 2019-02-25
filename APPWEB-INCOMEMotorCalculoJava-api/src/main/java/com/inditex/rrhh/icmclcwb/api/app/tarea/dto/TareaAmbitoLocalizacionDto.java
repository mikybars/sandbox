package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TareaAmbitoLocalizacionDto {

    @ApiModelProperty(value = "Identificador del ambito localizacion del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la localizacion", required = true, example = "T57")
    private String idLocalizacion;

}
