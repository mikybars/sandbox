package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo TipoDatoDto")
@Data
public class TipoDatoDto {

    @ApiModelProperty(value = "Identificador del tipo de dato", required = true)
    private String id;

    @NotBlank
    @ApiModelProperty(value = "Nombre identificativo del tipo de dato", required = true)
    private String nombre;

    @NotBlank
    @ApiModelProperty(value = "Descripción del dato", required = true)
    private String descripcion;

    @NotNull
    @ApiModelProperty(value = "Identificador del tipo de dato", required = true)
    private Boolean procesado;
}
