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
import lombok.Builder;
import lombok.Data;

/**
 * @author mdelrio
 *
 */
@ApiModel(description = "Modelo TareaFaseDto")
@Data
@Builder
public class TareaFaseAccionDto implements Serializable {

    @ApiModelProperty(value = "Identificador de tarea fase accion", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private Long id;
    
    @ApiModelProperty(value = "Identificador de tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private TareaFaseDto tareaFase;
    
    @ApiModelProperty(value = "Identificador de accion", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private AccionDto accion;
    
    @ApiModelProperty(value = "Identificador de punto de ejecucion", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private PuntoEjecucionDto puntoEjecucion;
    
    @ApiModelProperty(value = "Identificador de estado tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private EstadoTareaFaseAccionDto estadoTareaFaseAccion;
        
    @ApiModelProperty(value = "Fecha en la que se creo el tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private LocalDateTime fechaHoraCreacion;

    @ApiModelProperty(value = "Fecha en la que se empieza a procesar la fase", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraInicio;

    @ApiModelProperty(value = "Fecha en la que se termina de procesar la fase", required = false,
            accessMode = AccessMode.READ_ONLY, hidden = true)
    private LocalDateTime fechaHoraFin;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean activo;
}
