package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionVentaRepositoryProcesarCustom {

  void procesarRepartoEntregaDomicilioPorVentasAgrupaciones(@NonNull final TareaDto tareaDto);

  void procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(@NonNull TareaDto tareaDto);

}
