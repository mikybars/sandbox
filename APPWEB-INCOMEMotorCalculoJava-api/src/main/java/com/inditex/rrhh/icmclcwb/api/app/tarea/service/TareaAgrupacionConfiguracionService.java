package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TareaAgrupacionConfiguracionService {

    List<TareaAgrupacionConfiguracionDto> saveConfiguracionVentaOnline(@Valid @NotNull List<ConfiguracionVentaOnlineResultItemDto> data, @Valid @NotNull RunTareaDto tarea);
}
