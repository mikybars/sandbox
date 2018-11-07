package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.list;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaResponseListDTO {
	private List<PresenciasTotalTiendaResponseDTO> list;
}
