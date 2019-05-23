package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaEmpleadoSeccionEstructuraDto implements Serializable {
    
    private static final long serialVersionUID = -543194407813312935L;

    @ApiModelProperty(value = "Identificador del empleado estructura", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id origen", required = true)
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true)
    private String idEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Ordinal del empleado", required = true)
    private String orEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Id local del empleado", required = true)
    private String idEmpleadoLocal;

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
    @ApiModelProperty(value = "valor asociado a la seccion", required = false)
    private String valor;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en el calculo", required = true)
    private String idSeccionEfectiva;

    @NotNull
    @ApiModelProperty(value = "Seccion usada en la estructura", required = true)
    private String idSeccionEstructura;

    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFin;

}
