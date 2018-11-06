package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request;


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
public class TiposHorasRequestDTO {

	@ApiModelProperty(value = "Id origen", required = false)
	private Integer origen;
	
	@ApiModelProperty(value = "Id tipo hora", required = false)
	private Integer tipoHora;
	
	@ApiModelProperty(value = "Excluido denonimandor", required = false)
	private Boolean excluidoDenom;
	
	@ApiModelProperty(value = "Excluido calculo", required = false)
	private Boolean excluidoCalculo;
}