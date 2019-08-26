package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface LimpiezaRepositoryCustom {

    void limpieza(@NotNull @Valid final TareaDto tarea);

    void consolidar(@NotNull @Valid final TareaDto tarea);

}
