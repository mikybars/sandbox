package com.inditex.rrhh.icmclcwb.api.app.limpieza.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface LimpiezaService {

    void runTarea(@NotNull @Valid final TareaDto tarea);

}
