/**
 * 
 */
package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo ValidacionDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ValidacionDto implements Serializable {
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la validacion", required = true, example = "1")
    private Integer id;
    
    @ApiModelProperty(value = "Nombre de la validacion", required = true, example = "1")
    private String nombre;
    
    @NotNull
    @ApiModelProperty(value = "Flag activo", required = true)
    private Boolean delay;    
    
    @ApiModelProperty(value = "Tiempo para el delay de reintento", required = true)
    private Long delayTime;
    
    @NotNull
    @ApiModelProperty(value = "Numero de reintentos maximo", required = true, example = "1")
    private Integer maxReintentos;
    
    @NotNull
    @ApiModelProperty(value = "Tipo offline (0)/online (1)", required = true)
    private Integer idTipoEstadoValidacion;  
    
    @NotNull
    @ApiModelProperty(value = "Identificador del tipo de accion de la validacion", required = true, example = "1")
    private Integer idTipoAccionValidacion;
    
    @NotNull
    @ApiModelProperty(value = "Identificador de la prioridad de la validacion", required = true, example = "1")
    private Integer idPrioridadValidacion;
}
