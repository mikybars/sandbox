package com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasDetalleResponseDTO;

import lombok.Data;

@Data
public class PresenciasDetalleResponseListDTO {
	private List<PresenciasDetalleResponseDTO> list;
}
