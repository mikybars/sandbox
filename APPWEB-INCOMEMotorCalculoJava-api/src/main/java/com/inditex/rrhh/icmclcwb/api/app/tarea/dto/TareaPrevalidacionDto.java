/**
 * 
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Modelo TareaFlujoDto")
@Data
public class TareaPrevalidacionDto implements Serializable {

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea prevalidacion ", required = true)
    private Integer id;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del estado", required = true)
    private Integer idEstadoTareaPrevalidacion;
    
    @ApiModelProperty(value = "Fecha creación", required = true,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraCreacion;
    
    @ApiModelProperty(value = "Fecha actualización", required = true,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraActualizacion;
    
    @ApiModelProperty(value = "Fecha inicio", required = true,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraInicio;
    
    @ApiModelProperty(value = "Fecha fin", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraFin;
    
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo;
}
