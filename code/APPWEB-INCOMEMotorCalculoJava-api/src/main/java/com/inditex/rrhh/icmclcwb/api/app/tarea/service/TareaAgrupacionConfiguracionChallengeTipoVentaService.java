package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionConfiguracionChallengeTipoVentaService {

  void save(@Valid @NonNull @NotEmpty final List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src,
      @Valid @NonNull final TareaDto tarea);

  void saveConfChTpVentaResultItemDto(@Valid @NonNull @NotEmpty final List<ConfChTpVentaResultItemDto> src,
      @Valid @NonNull final TareaDto tarea);

}
