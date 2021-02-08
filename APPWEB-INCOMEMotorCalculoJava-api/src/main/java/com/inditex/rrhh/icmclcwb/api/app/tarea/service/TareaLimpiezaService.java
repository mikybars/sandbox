package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

public interface TareaLimpiezaService {

    void save(@Valid @NotNull final TareaDto tarea);

    TareaLimpiezaDto create(TareaLimpiezaDto tareaLimpieza);

    List<TareaLimpiezaDto> create(List<IdTareaDto> idTareas);

}
