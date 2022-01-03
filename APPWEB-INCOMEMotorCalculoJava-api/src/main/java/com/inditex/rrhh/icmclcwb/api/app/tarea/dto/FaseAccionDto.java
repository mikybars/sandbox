package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo FaseAccionDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaseAccionDto implements Serializable {

  @ApiModelProperty(value = "Identificador de fase", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idFase;

  @ApiModelProperty(value = "Identificador de accion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idAccion;

  @ApiModelProperty(value = "Identificador de punto ejecucion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idPuntoEjecucion;

  @ApiModelProperty(value = "Peso", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer peso;

}
