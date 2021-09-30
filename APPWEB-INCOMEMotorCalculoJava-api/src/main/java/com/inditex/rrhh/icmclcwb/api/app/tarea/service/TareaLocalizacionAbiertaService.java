package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

public interface TareaLocalizacionAbiertaService {

    void saveAbierto(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto);

    void saveCerrado(@Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final TrabajoDTO trabajoDto);

}
