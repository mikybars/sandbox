package com.inditex.rrhh.icmclcwb.model.app.calcular;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunAjuste {

    void execute(RunTareaDto runTarea, AlgoritmoAjusteDto algoritmoAjuste);

    String getSqlCalcular(AlgoritmoAjusteDto algoritmoAjuste);

}
