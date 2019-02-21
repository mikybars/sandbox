package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoAmbitoLocalizacionService {

    List<TrabajoAmbitoLocalizacionDto> create(
            @Valid @NotNull @NotEmpty final List<TrabajoAmbitoLocalizacionDto> programacionAmbitoLocalizacion,
            @NotNull final TrabajoDto trabajo);

}
