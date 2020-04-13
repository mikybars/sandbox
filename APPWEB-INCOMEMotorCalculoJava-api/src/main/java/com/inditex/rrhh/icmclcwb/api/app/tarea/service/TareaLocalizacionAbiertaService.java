package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaLocalizacionAbiertaService {

    void saveAbierto(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDto trabajoDto);

    void saveCerrado(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDto trabajoDto);

}
