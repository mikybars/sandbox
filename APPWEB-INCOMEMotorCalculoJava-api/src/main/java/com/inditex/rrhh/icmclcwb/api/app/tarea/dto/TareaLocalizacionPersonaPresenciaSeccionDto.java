package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@Data
public class TareaLocalizacionPersonaPresenciaSeccionDto implements Serializable {
    
    private static final long serialVersionUID = -3411003527403803419L;
    
    @ApiModelProperty(value = "Identificador de la tabla de presencia por seccion", required = false)
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
    @ApiModelProperty(value = "Ordinal de la persona", required = true)
    private String orPersona;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del origen", required = true)
    private Long idOrigen;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la empresa", required = true)
    private Long idEmpresa;
       
    @NotNull
    private Date fecha;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 1", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos1;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 2", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos2;
    
    @NotNull
    @ApiModelProperty(value = "Tiempo seccion 3", required = false, accessMode = AccessMode.READ_ONLY)
    private Long minutos3;
    
    @ApiModelProperty(value = "Identificador del tipo de hora", required = true)
    private String idTipoHora;
    
    @ApiModelProperty(value = "Flag activa", required = true)
    private Boolean activo;

}
