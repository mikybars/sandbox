package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaAmbitoGlobalFechaDto implements Serializable {

    @ApiModelProperty(value = "Identificador de la entidad", required = false, accessMode = AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Fecha de inicio", required = true)
    private Date fechaInicio;

    @NotNull
    @ApiModelProperty(value = "Fecha de fin", required = true)
    private Date fechaFin;

}
