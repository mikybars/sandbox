package com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PtrPresenciasMockTotalTiendaSeccionResponseDto {

	@NotNull
	private Integer tienda;

	private Date fecha;

	@NotNull
	private Integer seccion;

	@NotNull
	private Integer minutos;

}