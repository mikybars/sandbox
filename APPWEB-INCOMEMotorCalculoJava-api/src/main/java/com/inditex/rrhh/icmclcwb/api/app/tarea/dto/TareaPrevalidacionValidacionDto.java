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
@ApiModel(description = "Modelo TareaPrevalidacionValidacionDto")
@Data
public class TareaPrevalidacionValidacionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "Identificador del tarea prevalidacion validacion", required = true)
    private Integer id;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tarea prevalidacion", required = true)
    private Integer idTareaPrevalidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tarea", required = true)
    private Long idTarea;
    
    @ApiModelProperty(value = "Delay activo ", required = true)
    private Boolean delay;
    
    @NotNull
    @ApiModelProperty(value = "Maxmo numero de reintentos", required = true)
    private Integer reintentoMax;
    
    @NotNull
    @ApiModelProperty(value = "Delay del reintento", required = true)
    private Long reintentoDelay;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de tipo de estado de validacion", required = true)
    private Integer idTipoEstadoValidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de tipo de accion de validacion", required = true)
    private Integer idTipoAccionValidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de prioridad de validacion", required = true)
    private Integer idPrioridadValidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de estado de validacion", required = true)
    private Integer idEstadoValidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de tipo de validacion", required = true)
    private Integer idTipoValidacion;
    
    @ApiModelProperty(value = "Mensaje meta4", required = true)
    private String mensaje;
    
    @ApiModelProperty(value = "Fecha creación", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraCreacion;
    
    @ApiModelProperty(value = "Fecha actualización", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraActualizacion;
    
}
