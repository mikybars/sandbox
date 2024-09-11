package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarJornadaService {

  void procesarJornadaLocalizacionPersona(RunTareaDto runTarea);

  void procesarJornadaLocalizacion(RunTareaDto runTarea);
}
