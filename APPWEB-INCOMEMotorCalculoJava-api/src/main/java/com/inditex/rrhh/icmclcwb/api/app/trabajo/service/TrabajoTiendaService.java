package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaDto;

public interface TrabajoTiendaService {

    List<TrabajoTiendaDto> findByTrabajo(@Valid @NotNull final TrabajoDto trabajo);

    List<TrabajoTiendaDto> createTrabajoTienda(@Valid @NotNull final TrabajoDto trabajo,
            @NotNull final List<TrabajoTiendaDto> trabajoTienda);

}
