package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAmbitoGlobalFechaService {

    @Deprecated
    void save(@Valid @NotNull @NotEmpty List<TareaAmbitoGlobalFechaDto> src, @Valid @NotNull TareaDto tarea);

    void save(@Valid @NotNull TareaAmbitoGlobalFechaDto src, @Valid @NotNull TareaDto tarea);

    PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@Valid @NotNull Long idTarea, @NotNull Integer idTipoDato);

}
