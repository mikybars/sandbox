package com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaTotalTiendaResponseDto {

	private List<PtrPresenciaTotalTiendaResultItemDto> presenciasTotalTienda;

}
