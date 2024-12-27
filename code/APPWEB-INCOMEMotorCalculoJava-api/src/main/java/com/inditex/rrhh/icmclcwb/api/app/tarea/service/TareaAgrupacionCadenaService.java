package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionCadenaService {

  List<TareaAgrupacionCadenaDto> save(@Valid @NonNull @NotEmpty final List<AgrupOnlineResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

  List<TareaAgrupacionCadenasDto> findAgrupacionesByTarea(@Valid @NonNull final TareaDto tarea);

}
