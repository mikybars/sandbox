package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;

import java.util.List;

public interface TareaAgrupacionCadenaService {

    List<TareaAgrupacionCadenaDto> save(final List<AgrupOnlineResultItemDto> src, final TareaDto tarea);

    List<TareaAgrupacionCadenasDto> findAgrupacionesByTarea(final TareaDto tarea);

}
