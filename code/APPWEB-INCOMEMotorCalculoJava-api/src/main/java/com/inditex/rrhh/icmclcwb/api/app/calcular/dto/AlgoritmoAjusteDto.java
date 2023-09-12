package com.inditex.rrhh.icmclcwb.api.app.calcular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Modelo AlgoritmoAjusteDto")
@Data
public class AlgoritmoAjusteDto {

  @ApiModelProperty(value = "Identificador del ajuste", required = true)
  private Integer id;

  @ApiModelProperty(value = "Si el ajuste está [activo|inactivo]", required = true, example = "true")
  private Boolean activo;

  @ApiModelProperty(value = "Nombre del ajuste", required = true, example = "true")
  private String nombre;

  @ApiModelProperty(value = "Peso del ajuste", required = true, example = "true")
  private Integer peso;

}
