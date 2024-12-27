package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionVentaRespositoryProcesarCustom {

  void procesarRepartoEntregaDomicilio(@NonNull final TareaDto tareaDto);

}
