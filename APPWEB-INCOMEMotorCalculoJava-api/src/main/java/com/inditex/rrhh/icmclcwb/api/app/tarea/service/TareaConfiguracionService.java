package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;

import java.util.List;

public interface TareaConfiguracionService {

    public void save(final List<ConfiguracionItemDto> src, TareaDto tarea);
}
