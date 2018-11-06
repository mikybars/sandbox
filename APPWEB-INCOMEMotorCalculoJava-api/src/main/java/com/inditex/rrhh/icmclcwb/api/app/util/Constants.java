package com.inditex.rrhh.icmclcwb.api.app.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Constants {

	public static final String LOCAL_TIME_PATTERN = "([01][0-9]|2[0-3]):[0-5][0-9]";

	public static final String LOCAL_TIME_JSON = "HH:mm";

	@Getter
	@RequiredArgsConstructor
	public enum EstadoTrabajoEnum {

		PENDIENTE_DATOS(1L), EN_CURSO_DATOS(2L), PENDIENTE_CALCULO(3L), EN_CURSO_CALCULO(4L),
		PENDIENTE_CONSOLIDACION(5L), EN_CURSO_CONSOLIDACION(6L), FINALIZADO_SIN_ERRORES(7L), FINALIZADO_CON_ERRORES(8L),
		ERROR(9L);

		private final Long id;

	}

	@Getter
	@RequiredArgsConstructor
	public enum EstadoTrabajoEmpleadoEnum {

		PENDIENTE(1L), FINALIZADO(2L), ERROR(3L);

		private final Long id;

	}

	@Getter
	@RequiredArgsConstructor
	public enum EstadoTrabajoTiendaEnum {

		PENDIENTE(1L), FINALIZADO(2L), ERROR(3L);

		private final Long id;

	}

	@Getter
	@RequiredArgsConstructor
	public enum TipoTrabajoTiendaEnum {

		INICIAL(1L), PARAMETRO(2L), HISTORICO(3L), PRESENCIA(4L);

		private final Long id;

	}

}