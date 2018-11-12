package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

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
public class TiposHorasResponseDto {

	private Integer Origen;
	private Integer TipoHora;
	private Boolean excluidoDenom;
	private Boolean excluidoCalculo;

}
