package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaLocalizacionPersonaSeccionPresenciaDto implements Serializable {
    
    private static final long serialVersionUID = -5245069232542882963L;

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
    @ApiModelProperty(value = "Identificador de la seccion", required = true)
    private Long idSeccion;
    
    @NotNull
    private Date fecha;
    
    @NotNull
    @ApiModelProperty(value = "Minutos", required = true)
    private Long minutos;
    
    @ApiModelProperty(value = "Identificador del tipo de hora", required = true)
    private  String idTipoHora;
}
