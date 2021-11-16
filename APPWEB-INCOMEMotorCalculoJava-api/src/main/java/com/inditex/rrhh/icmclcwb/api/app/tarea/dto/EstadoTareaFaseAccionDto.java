package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "Modelo EstadoTareaFaseAccionDto")
@Data
@AllArgsConstructor
public class EstadoTareaFaseAccionDto {

  @ApiModelProperty(value = "Identificador de estado tarea fase accion", required = false,
      accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer id;

}
