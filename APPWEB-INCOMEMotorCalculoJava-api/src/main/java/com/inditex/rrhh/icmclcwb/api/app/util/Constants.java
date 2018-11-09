package com.inditex.rrhh.icmclcwb.api.app.util;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TipoTrabajoTiendaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Constants {

	public static final String LOCAL_TIME_PATTERN = "([01][0-9]|2[0-3]):[0-5][0-9]";

	public static final String LOCAL_TIME_JSON = "HH:mm";

	@Getter
	@RequiredArgsConstructor
	public static enum EstadoTrabajoEnum {

		PENDIENTE_DATOS(1L, new EstadoTrabajoDto(1L)), EN_CURSO_DATOS(2L, new EstadoTrabajoDto(2L)),
		PENDIENTE_CALCULO(3L, new EstadoTrabajoDto(3L)), EN_CURSO_CALCULO(4L, new EstadoTrabajoDto(4L)),
		PENDIENTE_CONSOLIDACION(5L, new EstadoTrabajoDto(5L)), EN_CURSO_CONSOLIDACION(6L, new EstadoTrabajoDto(6L)),
		FINALIZADO_SIN_ERRORES(7L, new EstadoTrabajoDto(7L)), FINALIZADO_CON_ERRORES(8L, new EstadoTrabajoDto(8L)),
		ERROR(9L, new EstadoTrabajoDto(9L));

		private final Long id;

		private final EstadoTrabajoDto dto;

	}

	@Getter
	@RequiredArgsConstructor
	public static enum EstadoTrabajoEmpleadoEnum {

		PENDIENTE(1L, new EstadoTrabajoEmpleadoDto(1L)), FINALIZADO(2L, new EstadoTrabajoEmpleadoDto(2L)),
		ERROR(3L, new EstadoTrabajoEmpleadoDto(3L));

		private final Long id;

		private final EstadoTrabajoEmpleadoDto dto;

	}

	@Getter
	@RequiredArgsConstructor
	public static enum EstadoTrabajoTiendaEnum {

		PENDIENTE(1L, new EstadoTrabajoTiendaDto(1L)), FINALIZADO(2L, new EstadoTrabajoTiendaDto(2L)),
		ERROR(3L, new EstadoTrabajoTiendaDto(3L));

		private final Long id;

		private final EstadoTrabajoTiendaDto dto;

	}

	@Getter
	@RequiredArgsConstructor
	public static enum TipoTrabajoTiendaEnum {

		INICIAL(1L, new TipoTrabajoTiendaDto(1L)), PARAMETRO(2L, new TipoTrabajoTiendaDto(2L)),
		HISTORICO(3L, new TipoTrabajoTiendaDto(3L)), PRESENCIA(4L, new TipoTrabajoTiendaDto(4L));

		private final Long id;
		
		private final TipoTrabajoTiendaDto dto;

	}

}