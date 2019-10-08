package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaService {

    void compensar(@NotNull final RunTareaDto runTareaDto);

    void totalizar(@NotNull final RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull final RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull final RunTareaDto runTareaDto);

    void totalizarEcommerce(@NotNull final RunTareaDto runTareaDto);

}
