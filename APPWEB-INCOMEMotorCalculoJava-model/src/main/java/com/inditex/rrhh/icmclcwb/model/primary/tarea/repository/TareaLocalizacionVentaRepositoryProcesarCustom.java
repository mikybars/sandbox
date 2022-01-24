package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.constraints.NotNull;

public interface TareaLocalizacionVentaRepositoryProcesarCustom {

  void procesarRepartoEntregaDomicilioPorVentasAgrupaciones(@NotNull final TareaDto tareaDto);

  void procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(@NotNull TareaDto tareaDto);

}
