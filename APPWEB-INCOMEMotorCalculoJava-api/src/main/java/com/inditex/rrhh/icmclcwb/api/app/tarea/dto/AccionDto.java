/**
 * 
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author mdelrio
 *
 */
@ApiModel(description = "Modelo AccionDto")
@Data
@Builder
@AllArgsConstructor
public class AccionDto implements Serializable {

    @ApiModelProperty(value = "Identificador de accion", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private Integer id;
    
    @NotBlank
    @ApiModelProperty(value = "Nombre", required = true)
    private String nombre;
} 
