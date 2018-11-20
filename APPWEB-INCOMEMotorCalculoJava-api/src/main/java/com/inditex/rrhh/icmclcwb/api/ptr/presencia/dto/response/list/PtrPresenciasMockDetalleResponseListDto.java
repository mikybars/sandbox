package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciasMockDetalleResponseListDto {

	private List<PtrPresenciasMockDetalleResponseDto> list;

}