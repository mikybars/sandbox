package com.inditex.rrhh.icmclcwb.model.app.postprocesar;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunPostCondicion {

    void execute(RunTareaDto runTarea);
    
    String getSqlCalcular();
}
