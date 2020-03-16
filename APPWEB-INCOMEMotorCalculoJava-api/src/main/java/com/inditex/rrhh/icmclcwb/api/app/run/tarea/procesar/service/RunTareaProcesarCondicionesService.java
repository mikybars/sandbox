package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;


import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;

public interface RunTareaProcesarCondicionesService {

    void updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea);

    void updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea);

    void updateActivoEstructuraTopes(@Valid final TareaDto tarea);

}
