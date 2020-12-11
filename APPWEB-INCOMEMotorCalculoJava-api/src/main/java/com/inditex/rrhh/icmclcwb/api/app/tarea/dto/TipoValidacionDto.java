package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo TipoValidacionDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TipoValidacionDto implements Serializable {

    @ApiModelProperty(value = "Identificador del tipo de validacion", required = true)
    private Integer id;

}
