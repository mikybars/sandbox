package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PtrPresenciaTiposHorasRequestDto {
	@NotNull
	@ApiModelProperty(value = "Id origen", required = false, example = "11")
	private Integer origen;

	@ApiModelProperty(value = "Id tipo hora", required = false, example = "1")
	private Integer tipoHora;

	@ApiModelProperty(value = "Excluido denonimandor", required = false, example = "true")
	private Boolean excluidoDenom;

	@ApiModelProperty(value = "Excluido calculo", required = false, example = "false")
	private Boolean excluidoCalculo;
}