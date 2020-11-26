package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo TipoEstadoValidacionDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TipoEstadoValidacionDto implements Serializable {

    @ApiModelProperty(value = "Identificador del tipo de estado de validacion", required = true)
    private Integer id;

}
