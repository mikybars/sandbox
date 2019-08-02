package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaDto implements Serializable {

    private static final long serialVersionUID = 5072975705443047327L;

    @ApiModelProperty(value = "Identificador de la tabla tienda abierta", required = false)
    private String id;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la tienda", required = true)
    private Long stdIdWorkLocat;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la persona", required = true)
    private Long cclIdPerson;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private Long cclIdOrigen;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la empresa", required = true)
    private Long stdIdLegEnt;
    
}
