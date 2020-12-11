package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo TipoAccionValidacionDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PrioridadValidacionDto implements Serializable {

    @ApiModelProperty(value = "Identificador de la prioridad de la validacion", required = true)
    private Integer id;

}
