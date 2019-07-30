package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaLocalizacionAbiertaDto implements Serializable {

    private static final long serialVersionUID = 5072975705443047327L;

    @ApiModelProperty(value = "Identificador de la tabla tienda abierta", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la localizacion", required = true)
    private Long idLocalizacion;
    
    @NotNull
    private Date fecha;
    
    @NotNull
    @ApiModelProperty(value = "Flag comisionable", required = true)
    private Boolean comisionable;
}
