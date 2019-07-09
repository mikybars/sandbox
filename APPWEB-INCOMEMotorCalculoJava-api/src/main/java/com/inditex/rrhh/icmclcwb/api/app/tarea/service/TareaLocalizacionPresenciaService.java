package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

public interface TareaLocalizacionPresenciaService {

    List<TareaLocalizacionPresenciaDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
        @Valid final TareaDto tarea);

    List<TareaLocalizacionPresenciaDto> saveEcommerce(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
        @Valid final TareaDto tarea);

    void updateActivo(@NotNull final RunTareaDto runTareaDto);

    void compensar(@NotNull final RunTareaDto runTareaDto);

    void totalizar(@NotNull final RunTareaDto runTareaDto);

    void compensarEcommerce(@NotNull final RunTareaDto runTareaDto);

    void updateActivoEcommerce(@NotNull final RunTareaDto runTareaDto);

}
