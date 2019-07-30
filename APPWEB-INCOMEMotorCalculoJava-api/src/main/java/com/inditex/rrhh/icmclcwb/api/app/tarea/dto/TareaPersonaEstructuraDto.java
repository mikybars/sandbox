package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaPersonaEstructuraDto implements Serializable {

    private static final long serialVersionUID = -543194407813312935L;

    @ApiModelProperty(value = "Identificador de la persona estructura", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id origen", required = true)
    private String cclIdOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true)
    private String stdIdHr;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true)
    private String stdOrHrPeriod;

    @NotBlank
    @ApiModelProperty(value = "Id local de la persona", required = true)
    private String cclIdPerson;

    @NotNull
    @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
    private String icmIdEstrComision;

    @NotNull
    @ApiModelProperty(value = "Id tipo calculo asociado a la estructura", required = true)
    private String icmIdTpCalculo;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
    private String icmIdTpComision;

    @NotNull
    @ApiModelProperty(value = "valor asociado a la seccion", required = true)
    private String valor;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
    private String cclIdSeccionEfectiva;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en la estructura", required = true)
    private String cclIdSeccionEstructura;

    @NotNull
    @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
    private Date fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
    private Date fechaFin;

}
