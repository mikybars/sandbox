package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaLocalizacionCalcularService {

    void save(@NotNull List<GenericTiendaResultItemDto> src, @NotNull TareaDto tareaDto);

}
