package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import java.util.Date;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiendaSeccionDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaSeccionResponseDTO {
	private Integer tienda;
	private Date fecha;
	private Integer seccion;
	private Integer minutos;
	

}
