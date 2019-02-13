package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque)
           ;

    void tiendasEmpleadoHistorico(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    void condicionesEmpleados(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    void empleadosTienda(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque)
           ;

    void tiendasPresencia(@Valid final TrabajoDto trabajo, @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque)
           ;

    void tiendasComisionable(@Valid final TrabajoDto trabajo,
            @Valid final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

}