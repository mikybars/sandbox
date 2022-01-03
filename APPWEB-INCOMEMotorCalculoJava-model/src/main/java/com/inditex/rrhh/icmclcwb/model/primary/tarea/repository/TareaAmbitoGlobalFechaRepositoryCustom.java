package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalFecha;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface TareaAmbitoGlobalFechaRepositoryCustom {

  List<TareaAmbitoGlobalFecha> save(List<TareaAmbitoGlobalFecha> src);

  PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(@NotNull @Positive Long idTarea, @NotNull Integer idTipoDato);

}
