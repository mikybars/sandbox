package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "Modelo EstadoLimpiezaDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoLimpiezaDto implements Serializable {

  private static final long serialVersionUID = 5812871987442400781L;

  @ApiModelProperty(value = "Identificador del estado de la limpieza", required = true)
  private Integer id;

}
