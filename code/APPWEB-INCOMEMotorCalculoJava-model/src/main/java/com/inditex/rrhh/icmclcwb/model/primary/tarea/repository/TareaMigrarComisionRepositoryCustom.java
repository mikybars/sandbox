package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import jakarta.validation.constraints.NotNull;

public interface TareaMigrarComisionRepositoryCustom {

  List<TareaMigrarComisionDto> findCalculoComisionByTareaActual(@NotNull TareaDto tarea);
}
