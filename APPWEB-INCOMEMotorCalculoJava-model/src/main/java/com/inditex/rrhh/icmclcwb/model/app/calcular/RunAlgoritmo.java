package com.inditex.rrhh.icmclcwb.model.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

public interface RunAlgoritmo {

    void execute(RunTareaDto runTarea, AlgoritmoDTO algoritmo);

    String getSqlCalcular(AlgoritmoDTO algoritmo);

}
