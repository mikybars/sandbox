package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstructuraDto;

public interface TrabajoEmpleadoEstructuraService {

    List<TrabajoEmpleadoEstructuraDto> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoHistorico,
            @Valid TrabajoDto trabajo); 
    
    Set<Long> findIdTipoCalculoByIdTrabajo(@Valid Long idTrabajo);
    

}
