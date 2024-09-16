package com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;

public interface RunTareaRegularizarCalculoService {

  void regularizarCalculoMejorOpcion(@Valid RunTareaDto runTarea);

  void regularizarMejorOpcionSinFechas(@Valid RunTareaDto runTarea);

  void regularizarMejorOpcionSinFechasTodoPeriodo(@Valid RunTareaDto runTarea);

}
