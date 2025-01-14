package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaConfiguracionPrecioHoraService {

  void save(@Valid @NonNull @NotEmpty final List<TareaConfiguracionPrecioHoraDto> src,
      @Valid @NonNull final TareaDto tarea);

  void saveConfPrecioHoraResultItemDto(@Valid @NonNull @NotEmpty final List<ConfPrecioHoraResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

}
