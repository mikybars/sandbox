package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaAgrupacionConfiguracionChallengeTipoVentaService {

  void save(@Valid @NotNull @NotEmpty final List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src,
      @Valid @NotNull final TareaDto tarea);

  void saveConfChTpVentaResultItemDto(@Valid @NotNull @NotEmpty final List<ConfChTpVentaResultItemDto> src,
      @Valid @NotNull final TareaDto tarea);

}
