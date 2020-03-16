package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;


import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarCondicionesService {

    void updateActivoPresupuestosBandaExcepcion(RunTareaDto runTarea);

    void updateActivoPresupuestosBandasSinExcepcion(RunTareaDto runTarea);

}
