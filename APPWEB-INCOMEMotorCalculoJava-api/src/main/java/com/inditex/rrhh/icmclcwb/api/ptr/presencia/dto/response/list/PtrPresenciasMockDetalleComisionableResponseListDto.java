package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciasMockDetalleComisionableResponseListDto {

	private List<PtrPresenciasMockDetalleComisionableResponseDto> list;

}
