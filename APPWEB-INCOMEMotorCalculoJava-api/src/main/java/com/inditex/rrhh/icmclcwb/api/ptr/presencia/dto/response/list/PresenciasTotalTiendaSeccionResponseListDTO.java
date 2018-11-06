package com.inditex.rrhh.icmclcwb.api.dto.ptr.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.PresenciasTotalTiendaSeccionResponseDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaSeccionResponseListDTO {
	private List<PresenciasTotalTiendaSeccionResponseDTO> list;
}
