package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo AccionDto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccionDto implements Serializable {

  @ApiModelProperty(value = "Identificador de accion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer id;

  @ApiModelProperty(value = "Nombre de la accion", required = true, example = "motivosDesplazamientoV1")
  private String nombre;

  @ApiModelProperty(value = "Descripcion de la accion", required = true, example = "Texto descriptivo")
  private String descripcion;

  @ApiModelProperty(value = "Peso", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer peso;

  @ApiModelProperty(value = "Flag que indica si hay que usar delay", required = true)
  private Boolean esReaccionEsperar;

  @ApiModelProperty(value = "Flag que indica si hay que reintentar", required = true)
  private Boolean esReaccionReintento;

  @ApiModelProperty(value = "Numero maximo de reintentos", required = true)
  private Integer reintentoMax;

  @ApiModelProperty(value = "Delay en los reintentos", required = true)
  private Integer reintentoDelay;

}
