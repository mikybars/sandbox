package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoHistoricoDto;

public interface TrabajoEmpleadoHistoricoService {

    List<TrabajoEmpleadoHistoricoDto> save(List<TrabajoEmpleadoHistoricoDto> trabajoEmpleadoHistorico,
            @Valid TrabajoDto trabajo) throws Exception;


}
