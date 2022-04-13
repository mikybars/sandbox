package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

/*
 * Copyright (c) 2022. Inditex
 */
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo TareaFaseAccionFallidasDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionFallidasDto implements Serializable {

  @ApiModelProperty(value = "Identificador de TareaFaseAccion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idTareaFaseAccion;

  @ApiModelProperty(value = "Identificador de TipoFallidas", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idTipoFallidas;

  @ApiModelProperty(value = "Listado de afectados por el fallo", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private String fallidas;

}
