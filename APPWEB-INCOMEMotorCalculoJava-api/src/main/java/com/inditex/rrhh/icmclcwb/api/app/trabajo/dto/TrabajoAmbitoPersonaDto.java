package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TrabajoAmbitoPersonaDto implements Serializable {

    private static final long serialVersionUID = 3468264496961245295L;

    @ApiModelProperty(value = "Identificador del ambito persona del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long id;

    @ApiModelProperty(value = "Identificador del ambito del trabajo", required = false, accessMode = AccessMode.READ_ONLY, hidden = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id de la sociedad", required = true, example = "11")
    private String cclIdOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la empresa", required = true, example = "8")
    private String stdIdLegEnt;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true, example = "1000")
    private String cclIdPerson;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true, example = "1")
    private String stdOrHrPeriod;

}
