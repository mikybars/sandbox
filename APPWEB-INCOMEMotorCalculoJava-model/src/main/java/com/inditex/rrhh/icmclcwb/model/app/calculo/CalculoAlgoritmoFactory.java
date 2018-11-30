package com.inditex.rrhh.icmclcwb.model.app.calculo;

import org.springframework.stereotype.Service;

@Service
public class CalculoAlgoritmoFactory {
			

	public TipoCalculoAlgoritmo crearAlgoritmo(TipoCalculoEnum tipo) {
		return tipo.crear();
	}
	
}

