package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaLocalizacionVentaRespositoryProcesarCustom {

  void procesarRepartoEntregaDomicilio(@NotNull final TareaDto tareaDto);

}
