package com.inditex.rrhh.icmclcwb.model.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunAlgoritmo {
	
    void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo);
    
    String getSqlCalcular(AlgoritmoDto algoritmo);
	
}
