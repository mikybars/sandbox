package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaSeccionResponseListDTO {
	private List<PresenciasTotalTiendaSeccionResponseDTO> list;
}
