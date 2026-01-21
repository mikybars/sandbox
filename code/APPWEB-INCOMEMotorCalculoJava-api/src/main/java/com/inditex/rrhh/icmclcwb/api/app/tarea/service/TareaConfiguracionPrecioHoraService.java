package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaConfiguracionPrecioHoraService {

  void save(@Valid @NotNull @NotEmpty final List<TareaConfiguracionPrecioHoraDto> src,
      @Valid @NotNull final TareaDto tarea);

  void saveConfiguracionPrecioHoraResponseDTO(@Valid @NotNull @NotEmpty final List<ConfiguracionPrecioHoraResponseDTO> src,
      @Valid @NotNull final TareaDto tarea, @Valid @NotNull final String cclIdOrigen);

}
