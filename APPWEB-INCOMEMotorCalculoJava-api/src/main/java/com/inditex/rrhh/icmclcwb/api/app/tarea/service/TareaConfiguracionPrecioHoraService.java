package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TareaConfiguracionPrecioHoraService {

  void save(@Valid @NotNull @NotEmpty final List<TareaConfiguracionPrecioHoraDto> src,
      @Valid @NotNull final TareaDto tarea);

  void saveConfPrecioHoraResultItemDto(@Valid @NotNull @NotEmpty final List<ConfPrecioHoraResultItemDto> src,
      @Valid @NotNull final TareaDto tarea);

}
