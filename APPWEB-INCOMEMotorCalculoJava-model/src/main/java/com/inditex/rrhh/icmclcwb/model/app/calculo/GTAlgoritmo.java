package com.inditex.rrhh.icmclcwb.model.app.calculo;

import org.springframework.stereotype.Component;

@Component
public class GTAlgoritmo implements TipoCalculoAlgoritmo{
	
	@Override
	public boolean executeScript() {
		
		System.out.println("ejecuta script global tienda");
		
		return true;
	}


}
