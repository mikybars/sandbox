package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TareaLocalizacionFestivoDto implements Serializable {
    
    private static final long serialVersionUID = -3737607409295676791L;

    @ApiModelProperty(value = "Identificador de la tabla localizacion festivo", required = false)
    private String id;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la localizacion", required = true)
    private Long idLocalizacion;
    
    @NotNull
    private Date fecha;
}
