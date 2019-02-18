package com.inditex.rrhh.icmclcwb.model.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaDto;

import reactor.core.publisher.Flux;

public interface Algoritmo {
	
	Flux<Void> execute(RunTareaDto runTarea);
	
}
