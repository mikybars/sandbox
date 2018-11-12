package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;

import lombok.Data;

@Data
public class PresenciasTotalTiendaResponseListDto {
	private List<PresenciasTotalTiendaResponseDto> list;
}
