package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class TareaAgrupacionCadenaDto implements Serializable {

    private static final long serialVersionUID = -8140438304912881020L;

    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;

    @NotBlank
    @ApiModelProperty(value = "Id origen", required = true)
    private String idOrigen;

    @NotBlank
    @ApiModelProperty(value = "Id de la agrupacion", required = true)
    private String idAgrupacion;

    @NotBlank
    @ApiModelProperty(value = "Id de la cadena", required = true)
    private String idCadena;
}
