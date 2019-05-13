package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaPeriodoDto implements Serializable {
    
    private static final long serialVersionUID = 957494461005830495L;

    @ApiModelProperty(value = "Identificador de la tabla tarea localizacion calcular", required = false)
    private String id;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    private Date fechaInicio;
    
    @NotNull
    private Date fechaFin;
    
    @NotNull
    @ApiModelProperty(value = "Flag modificado", required = true)
    private Boolean modificado;
    
    @NotNull
    @ApiModelProperty(value = "Flag nuevo", required = true)
    private Boolean nuevo;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo;
    
    @NotNull
    @ApiModelProperty(value = "Flag abierto", required = true)
    private Boolean abierto;
    
    @NotNull
    @ApiModelProperty(value = "Flag borrado", required = true)
    private Boolean borrado;
    
    @NotBlank
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private String idOrigen;
    
    @NotBlank
    @ApiModelProperty(value = "Identificador del periodo", required = true)
    private String idPeriodo;
    
}
