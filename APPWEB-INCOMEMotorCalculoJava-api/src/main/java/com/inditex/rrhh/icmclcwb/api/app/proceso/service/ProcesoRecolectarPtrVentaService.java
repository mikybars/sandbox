package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarPtrVentaService {

    void ventaDetalleEmpleado(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void ventaTotalizadaTienda(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}