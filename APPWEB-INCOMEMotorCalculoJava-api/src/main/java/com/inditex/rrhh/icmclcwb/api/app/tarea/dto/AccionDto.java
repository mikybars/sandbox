/**
 * 
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

/**
 * @author mdelrio
 *
 */
@ApiModel(description = "Modelo AccionDto")
@Data
public class AccionDto implements Serializable {

    @ApiModelProperty(value = "Identificador de accion", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private Long id;
} 
