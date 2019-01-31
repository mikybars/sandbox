package com.inditex.rrhh.icmclcwb.api.app.trabajo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TrabajoEmpleadoEstructuraDto implements Serializable {

    private static final long serialVersionUID = -7035758911645090409L;

    @ApiModelProperty(value = "Identificador del empleado estructura", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del trabajo", required = true)
    private Long idTrabajo;

    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true)
    private String idEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Ordinal del periodo", required = true)
    private String orEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Id local del empleado", required = true)
    private String idEmpleadoLocal;

    @NotNull
    @ApiModelProperty(value = "Id estructura asociada al empleado por APV", required = true)
    private Long idEstructura;

    @NotNull
    @ApiModelProperty(value = "Id formula calculo a aplicar", required = true)
    private Long idTipoCalculo;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
    private Long idTipoComision;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a todas las secciones ", required = true)
    private Double porcentaje;

    @NotNull
    private Double porcentaje1;

    @NotNull
    private Double porcentaje2;

    @NotNull
    private Double porcentaje3;

    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFin;

}
