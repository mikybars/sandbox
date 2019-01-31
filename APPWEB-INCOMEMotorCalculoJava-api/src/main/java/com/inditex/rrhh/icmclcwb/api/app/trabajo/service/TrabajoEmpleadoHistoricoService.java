package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoHistoricoDto;

public interface TrabajoEmpleadoHistoricoService {

    List<TrabajoEmpleadoHistoricoDto> save(List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico,
            @Valid TrabajoDto trabajo) throws Exception;


}
