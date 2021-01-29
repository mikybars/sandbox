/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Builder;
import lombok.Data;

/**
 * @author mdelrio
 *
 */
@ApiModel(description = "Modelo PuntoEjecucionDto")
@Data
@Builder
public class PuntoEjecucionDto implements Serializable {

    @ApiModelProperty(value = "Identificador de punto de ejecucion", required = false,
            accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private Integer id;

}
