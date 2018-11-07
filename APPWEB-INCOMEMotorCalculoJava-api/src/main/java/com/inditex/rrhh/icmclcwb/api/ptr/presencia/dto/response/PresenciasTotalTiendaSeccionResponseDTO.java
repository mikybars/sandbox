package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiendaSeccionDTO;

import lombok.Data;

@Data
public class PresenciasTotalTiendaSeccionResponseDTO {
	@NotNull
	private Integer tienda;
	private Date fecha;
	@NotNull
	private Integer seccion;
	@NotNull
	private Integer minutos;
	

}
