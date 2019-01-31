package com.inditex.rrhh.icmclcwb.model.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;

import reactor.core.publisher.Flux;

public interface TipoCalculoAlgoritmo {
	
	Flux<Void> execute(RunTrabajoDto trabajoRunDto);
	
}
