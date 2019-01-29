package com.inditex.rrhh.icmclcwb.model.app.calculo;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;

import reactor.core.publisher.Flux;

public interface TipoCalculoAlgoritmo {
	
	Flux<Void> execute(TrabajoRunDto trabajoRunDto);
	
}
