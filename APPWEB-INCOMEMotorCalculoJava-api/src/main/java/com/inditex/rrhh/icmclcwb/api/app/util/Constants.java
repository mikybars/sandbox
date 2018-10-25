package com.inditex.rrhh.icmclcwb.api.app.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Constants {

	@Getter
	@RequiredArgsConstructor
	public enum EstadoTrabajoEnum {

		PENDIENTE_DATOS(1L), EN_CURSO_DATOS(2L), PENDIENTE_CALCULO(3L), EN_CURSO_CALCULO(4L),
		PENDIENTE_CONSOLIDACION(5L), EN_CURSO_CONSOLIDACION(6L), FINALIZADO_SIN_ERRORES(7L), FINALIZADO_CON_ERRORES(8L),
		ERROR(9L);

		private final Long id;

	}

}