package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarPtrVentaService {

    void ventaDetalleEmpleado(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception;

    void ventaTotalizadaTienda(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception;

}