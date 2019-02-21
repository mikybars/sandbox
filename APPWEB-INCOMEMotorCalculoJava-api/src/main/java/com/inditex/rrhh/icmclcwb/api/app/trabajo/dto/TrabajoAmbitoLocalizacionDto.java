package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TrabajoAmbitoLocalizacionDto {

    @ApiModelProperty(value = "Identificador del ambito localizacion del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
    private String idEmpresa;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la empresa", required = true, example = "T57")
    private String idLocalizacion;

}
