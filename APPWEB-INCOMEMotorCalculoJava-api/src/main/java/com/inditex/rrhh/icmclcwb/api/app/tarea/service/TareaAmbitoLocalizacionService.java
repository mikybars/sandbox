package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaAmbitoLocalizacionService {

    List<TrabajoAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoLocalizacionDto> programacionAmbitoLocalizacion,
            @NotNull final TrabajoDto trabajo);

}
