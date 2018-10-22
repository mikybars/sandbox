package com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaResponseListDTO {
	private List<PresenciasTotalTiendaResponseDTO> list;
}
