package com.inditex.rrhh.icmclcwb.model.app.trabajo;

import java.util.Arrays;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;

public enum TipoCalculoEnum {

	GLOBAL_TIENDA(1L, "gTAlgoritmo");	

	private final Long id;
	private final String type;

	
	private TipoCalculoEnum(Long id, String type) {
		this.id = id;
		this.type = type;
	}
	

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	

	public static TipoCalculoEnum of(Long idTipoCalculo) {
		return Arrays.stream(values()).filter(value -> value.getId().equals(idTipoCalculo)).findAny().orElseThrow(
				() -> new ApplicationException(String.format("No existe el tipo de calculo  %s", idTipoCalculo)));
	}

}
