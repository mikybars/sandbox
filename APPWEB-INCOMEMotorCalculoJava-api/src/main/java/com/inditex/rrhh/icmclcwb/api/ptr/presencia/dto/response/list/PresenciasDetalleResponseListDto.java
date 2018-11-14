package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PresenciasDetalleResponseListDto {

	private List<PresenciasDetalleResponseDto> list;

}