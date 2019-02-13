package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarPtrPresenciaService {

    void tiposHoras(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    void presenciaDetalleEmpleado(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    void presenciaTotalizadaTienda(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

}