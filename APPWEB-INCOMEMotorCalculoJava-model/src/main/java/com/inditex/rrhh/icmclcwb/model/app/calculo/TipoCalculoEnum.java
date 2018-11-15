package com.inditex.rrhh.icmclcwb.model.app.calculo;

import java.util.Arrays;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;;


public enum TipoCalculoEnum {
	
	GLOBAL_TIENDA(1) {
		@Override
		public TipoCalculoAlgoritmo crear() {			
			return new GTAlgoritmo();
		}
	};
	
	private Integer tipoCalculo;	
	
	private TipoCalculoEnum(Integer tipoCalculo) {
		this.tipoCalculo = tipoCalculo;		
	}
	
	private Integer tipoCalculo() {
		return tipoCalculo;
	}
	
	
	public static TipoCalculoEnum of(Integer tipoCalculo) {
		return Arrays.stream(values())
				.filter(value -> value.tipoCalculo().equals(tipoCalculo))
				.findAny()
				.orElseThrow(() -> new ApplicationException(String.format("No existe el tipo de calculo  %s", tipoCalculo)));
	}


	public abstract TipoCalculoAlgoritmo crear();
	
	
}
