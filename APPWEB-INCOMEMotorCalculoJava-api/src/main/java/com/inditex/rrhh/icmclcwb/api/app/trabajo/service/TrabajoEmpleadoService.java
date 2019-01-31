package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoDto;

public interface TrabajoEmpleadoService {

    List<TrabajoEmpleadoDto> findByTrabajo(@Valid final TrabajoDto trabajo);
    
    List<TrabajoEmpleadoDto> createTrabajoEmpleado(@Valid final TrabajoDto trabajo, final List<TrabajoEmpleadoDto> trabajoEmpleado);

}
