package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstructuraDto;

public interface TrabajoEmpleadoEstructuraService {

    List<TrabajoEmpleadoEstructuraDto> save(final List<TrabajoEmpleadoEstructuraDto> trabajoEmpleadoHistorico,
            @Valid TrabajoDto trabajo);    
    
    List<TrabajoEmpleadoEstructuraDto> findIdsEstructuraByIdTrabajo (@Valid Long idTrabajo);
    

}
