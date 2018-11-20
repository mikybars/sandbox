package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciasMockTotalTiendaResponseListDto {

	private List<PtrPresenciasMockTotalTiendaResponseDto> list;

}
