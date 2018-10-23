package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO.TiposHorasRequestDTOBuilder;

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
public class TiposHorasResponseDTO {

	private Integer Origen;
	private Integer TipoHora;
	private Boolean excluidoDenom;
	private Boolean excluidoCalculo;

}
