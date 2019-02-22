package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaAmbitoPersonaService {

    List<TrabajoAmbitoPersonaDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoPersonaDto> programacionAmbitoPersona,
            @NotNull final TrabajoDto trabajo);

}
