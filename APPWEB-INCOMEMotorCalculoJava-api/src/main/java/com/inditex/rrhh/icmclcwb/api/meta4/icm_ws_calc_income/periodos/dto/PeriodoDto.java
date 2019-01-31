package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_calc_income.periodos.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo PeriodoDto")
@Data
public class PeriodoDto implements Serializable {

	private static final long serialVersionUID = -5607507260079003307L;

	@ApiModelProperty(value = "Identificador del periodo", required = false)
	private String id;
	
	@NotNull
	@ApiModelProperty(value = "Fecha inicio del periodo a procesar", required = true)
	private LocalDateTime fechaInicioPeriodo;

	@NotNull
	@ApiModelProperty(value = "Fecha fin del periodo a procesar", required = true)
	private LocalDateTime fechaFinPeriodo;

}