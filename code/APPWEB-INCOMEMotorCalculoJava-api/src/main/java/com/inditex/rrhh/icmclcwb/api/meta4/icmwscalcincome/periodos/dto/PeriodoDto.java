package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@ApiModel(description = "Modelo PeriodoDto")
@Data
public class PeriodoDto implements Serializable {

  private static final long serialVersionUID = -5607507260079003307L;

  @ApiModelProperty(value = "Identificador del periodo", required = false)
  private Long id;

  @NotNull
  @ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true)
  private LocalDate fechaInicioPeriodo;

  @NotNull
  @ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true)
  private LocalDate fechaFinPeriodo;

}
