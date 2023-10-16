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

@ApiModel(description = "Modelo TareaFaseAccionDatoDto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaFaseAccionDatoDto implements Serializable {

  @ApiModelProperty(value = "Identificador de TareaFaseAccion", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Long idTareaFaseAccion;

  @ApiModelProperty(value = "Identificador de TipoDato", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private Integer idTipoDato;

  @ApiModelProperty(value = "Dato", required = false, accessMode = AccessMode.READ_ONLY,
      hidden = true)
  private String dato;

}
