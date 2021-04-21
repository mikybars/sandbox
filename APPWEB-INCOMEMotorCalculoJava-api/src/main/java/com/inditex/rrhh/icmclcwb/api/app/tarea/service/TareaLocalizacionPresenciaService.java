package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

public interface TareaLocalizacionPresenciaService {

    void compensar(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizar(@Valid @NotNull final RunTareaDto runTareaDto);

    void compensarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto);

    void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto);

    void totalizarEmpleadosPorVenta(@Valid @NotNull final RunTareaDto runTareaDto);

    void save(@Valid @NotNull @NotEmpty final List<PresenciaManualWlocResultItemDto> src,
            @Valid @NotNull final TareaDto tareaDto);

    void compensarLocalizacionManual(@Valid @NotNull final RunTareaDto runTareaDto);

}
