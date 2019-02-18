package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Data
public class TareaEmpleadoDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true, example = "1000")
    private String idEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Ordinal del empleado", required = true, example = "1")
    private String orEmpleado;

}