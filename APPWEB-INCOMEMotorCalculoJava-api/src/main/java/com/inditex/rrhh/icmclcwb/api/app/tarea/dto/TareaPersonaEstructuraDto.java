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
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la persona", required = true)
    private String idPersona;

    @NotBlank
    @ApiModelProperty(value = "Ordinal de la persona", required = true)
    private String orPersona;

    @NotBlank
    @ApiModelProperty(value = "Id local de la persona", required = true)
    private String idPersonaLocal;

    @NotNull
    @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
    private String idEstructura;

    @NotNull
    @ApiModelProperty(value = "Id tipo calculo asociado a la estructura", required = true)
    private String idTipoCalculo;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
    private String idTipoComision;

    @NotNull
    @ApiModelProperty(value = "valor asociado a la seccion", required = true)
    private String valor;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
    private String idSeccionEfectiva;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en la estructura", required = true)
    private String idSeccionEstructura;

    @NotNull
    @ApiModelProperty(value = "Fecha de inicio en la estructura", required = true)
    private Date fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin en la estructura", required = true)
    private Date fechaFin;

}
