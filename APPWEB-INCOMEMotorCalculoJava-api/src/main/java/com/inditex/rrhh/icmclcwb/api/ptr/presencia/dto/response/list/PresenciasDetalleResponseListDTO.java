package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDTO;

import lombok.Data;

@Data
public class PresenciasDetalleResponseListDTO {
	private List<PresenciasDetalleResponseDTO> list;
}
