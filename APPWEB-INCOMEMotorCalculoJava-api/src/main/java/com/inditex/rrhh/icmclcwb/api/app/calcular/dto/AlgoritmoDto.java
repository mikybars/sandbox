package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

@ApiModel(description = "Modelo AlgoritmoDto")
@Data
public class AlgoritmoDto implements Serializable {

    private static final long serialVersionUID = -8045541542256497791L;

    @ApiModelProperty(value = "Identificador del algoritmo", required = true)
    private Integer id;

    @ApiModelProperty(value = "Si el algoritmo está [activo|inactivo]", required = true, example = "true")
    private Boolean activo;

    @ApiModelProperty(value = "Nombre del algoritmo", required = true, example = "true")
    private String nombre;

    @ApiModelProperty(value = "Tipo de comisión asociado", required = false, accessMode = AccessMode.READ_ONLY)
    private List<TipoComisionDto> tipoComision;

    @ApiModelProperty(value = "Tipo de calculo asociado", required = false, accessMode = AccessMode.READ_ONLY)
    private List<TipoCalculoDto> tipoCalculo;

    @ApiModelProperty(value = "Tipo de dato asociado", required = false, accessMode = AccessMode.READ_ONLY)
    private List<TipoDatoDto> tipoDato;

}
