package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo TipoCalculoDto")
@Data
public class TipoCalculoDto implements Serializable {

    private static final long serialVersionUID = -5773205858357489594L;

    @ApiModelProperty(value = "Identificador del tipo de calculo", required = true)
    private /* BigInteger */ Long id;
}
