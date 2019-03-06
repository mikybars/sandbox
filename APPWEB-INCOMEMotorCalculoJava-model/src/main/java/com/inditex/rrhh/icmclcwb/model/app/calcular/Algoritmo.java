package com.inditex.rrhh.icmclcwb.model.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import reactor.core.publisher.Flux;

public interface Algoritmo {
	
    Flux<Void> execute(RunTareaDto runTarea, AlgoritmoDto algoritmo);
	
}
