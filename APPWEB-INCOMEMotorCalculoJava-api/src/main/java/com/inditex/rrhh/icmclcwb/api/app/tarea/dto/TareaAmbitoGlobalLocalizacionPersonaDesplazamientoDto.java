package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDto implements Serializable {

    private static final long serialVersionUID = 8643089032888418145L;

    @ApiModelProperty(value = "Identificador de la tabla tienda abierta", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la tienda", required = true)
    private Long idLocalizacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la persona", required = true)
    private Long idPersona;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private Long idOrigen;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la empresa", required = true)
    private Long idEmpresa;
}
