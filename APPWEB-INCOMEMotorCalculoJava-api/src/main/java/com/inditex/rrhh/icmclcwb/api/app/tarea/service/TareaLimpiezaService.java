package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

public interface TareaLimpiezaService {

    TareaLimpiezaDto save(TareaLimpiezaDto tareaLimpieza);

    List<TareaLimpiezaDto> save(List<IdTareaDto> idTareas);

    TareaLimpiezaDto find(Long id);

}
