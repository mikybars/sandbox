package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import javax.validation.constraints.NotNull;

public interface TareaLocalizacionPresenciaService {

    void compensar(@NotNull final RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoDestino(@NotNull final RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoOrigen(@NotNull final RunTareaDto runTareaDto);

    void totalizar(@NotNull final RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull final RunTareaDto runTareaDto);

    void updateActivoVacio(@NotNull final RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoDestinoEcommerce(@NotNull final RunTareaDto runTareaDto);

    void incluirPresenciasDesplazamientoOrigenEcommerce(@NotNull final RunTareaDto runTareaDto);

}
