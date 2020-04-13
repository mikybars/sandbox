package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaLocalizacionPresenciaService {

    void compensar(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizar(@Valid @NotNull final RunTareaDto runTareaDto);

    void compensarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto);

    void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizarEmpleadosPorVenta(@Valid @NotNull final RunTareaDto runTareaDto);

}
