package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaDto;

public interface TrabajoTiendaService {

    List<TrabajoTiendaDto> findByTrabajo(@Valid final TrabajoDto trabajo);
    
    List<TrabajoTiendaDto> createTrabajoTienda(@Valid final TrabajoDto trabajo, final List<TrabajoTiendaDto> trabajoTienda);

}
