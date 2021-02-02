/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mdelrio
 *
 */
@ApiModel(description = "Modelo EstadoTareaFaseDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoTareaFaseDto {

    @ApiModelProperty(value = "Identificador de estado tarea fase", required = false, accessMode = AccessMode.READ_ONLY,
            hidden = true)
    private Integer id;

}
