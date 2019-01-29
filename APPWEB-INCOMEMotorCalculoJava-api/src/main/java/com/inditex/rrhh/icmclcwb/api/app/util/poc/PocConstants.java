package com.inditex.rrhh.icmclcwb.api.app.util.poc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class PocConstants {

	public static final String SEPARADOR_TIENDA = ",";
	
	@Getter
	@RequiredArgsConstructor
	public enum PocSistemaEnum {

		JAVA("JAVA"), META4("META4");

		private final String sistema;

	}

}