package com.inditex.rrhh.icmclcwb.api.app.proceso.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo TipoComisionDto")
@Data
public class TipoComisionDto implements Serializable{

    private static final long serialVersionUID = -3656530078406256961L;
    
    @ApiModelProperty(value = "Identificador del tipo de comision", required = true)
    private String id;

}
