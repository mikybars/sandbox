package com.inditex.rrhh.icmclcwb.api.app.dto;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Data
public class ProgramacionEmpleadoDto implements Serializable {

    private static final long serialVersionUID = -5607507260079003307L;

    @ApiModelProperty(value = "Identificador de la tienda", required = false, readOnly = true, hidden = true)
    private String id;

    @ApiModelProperty(value = "Programación", required = false, readOnly = true, hidden = true)
    private Long idProgramacion;

    @NotBlank
    @ApiModelProperty(value = "Id del empleado", required = true, example = "1000")
    private String idEmpleado;

    @NotBlank
    @ApiModelProperty(value = "Ordinal del empleado", required = true, example = "1")
    private String orEmpleado;

}