package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalFechaRepositoryCustom {

  List<TareaAmbitoGlobalFecha> save(List<TareaAmbitoGlobalFecha> src);

  PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@NonNull @Positive Long idTarea, @NonNull Integer idTipoDato);

}
