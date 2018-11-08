package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;

import lombok.Data;

@Data
public class PresenciasTotalTiendaSeccionResponseListDto {
	private List<PresenciasTotalTiendaSeccionResponseDto> list;
}
