package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaEmpleadoEstructuraDto implements Serializable {

    private static final long serialVersionUID = -7035758911645090409L;

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
    private Long idEstructura;

    @NotNull
    @ApiModelProperty(value = "Id tipo calculo asociado a la estructura", required = true)
    private String idTipoCalculo;

    @NotNull
    @ApiModelProperty(value = "Id tipo comisión asociado a la estructura ", required = true)
    private String idTipoComision;

    @ApiModelProperty(value = "Porcentaje asociado a todas las secciones ", required = false)
    private Double porcentaje;

    @ApiModelProperty(value = "Porcentaje asociado a la seccion 1", required = false)
    private Double porcentaje1;

    @ApiModelProperty(value = "Porcentaje asociado a la seccion 2", required = false)
    private Double porcentaje2;

    @ApiModelProperty(value = "Porcentaje asociado a la seccion 3", required = false)
    private Double porcentaje3;

    @NotNull
    private Date fechaInicio;

    @NotNull
    private Date fechaFin;

}
