package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaAgrupacionConfiguracionService {

  List<TareaAgrupacionConfiguracionDto> saveConfiguracionVentaOnline(
      @Valid @NotNull @NotEmpty final List<ConfiguracionVentaOnlineResultItemDto> data,
      @Valid @NotNull final RunTareaDto tarea);

}
