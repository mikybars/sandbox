package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionConfiguracionService {

  List<TareaAgrupacionConfiguracionDto> saveConfiguracionVentaOnline(
      @Valid @NonNull @NotEmpty final List<ConfiguracionVentaOnlineResultItemDto> data,
      @Valid @NonNull final RunTareaDto tarea);

}
