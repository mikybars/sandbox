package com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRegularizarCalculoService {

    void regularizarCalculoMejorOpcion(@Valid RunTareaDto runTarea);

    void regularizarMejorOpcionSinFechas(@Valid RunTareaDto runTarea);

    void regularizarMejorOpcionSinFechasTodoPeriodo(@Valid RunTareaDto runTarea);

}
