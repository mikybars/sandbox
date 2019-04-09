package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaLocalizacionAbiertaService {

    void saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto);

    void saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto);

}
