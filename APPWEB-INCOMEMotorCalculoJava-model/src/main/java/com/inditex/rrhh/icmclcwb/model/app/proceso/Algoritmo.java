package com.inditex.rrhh.icmclcwb.model.app.proceso;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;

import reactor.core.publisher.Flux;

public interface Algoritmo {
	
    Flux<Void> execute(RunProcesoDto runProceso, AlgoritmoDto algoritmo);
	
}
