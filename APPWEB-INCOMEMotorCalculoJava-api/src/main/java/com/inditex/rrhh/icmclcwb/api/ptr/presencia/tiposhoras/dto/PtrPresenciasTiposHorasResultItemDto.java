package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

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
public class PtrPresenciasTiposHorasResultItemDto {

	private Integer origen;
	private Integer tipoHora;
	private Boolean excluidoDenom;
	private Boolean excluidoCalculo;

}
