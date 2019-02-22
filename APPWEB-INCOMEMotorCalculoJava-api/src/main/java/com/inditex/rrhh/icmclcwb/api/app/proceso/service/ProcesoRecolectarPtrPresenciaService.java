package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarPtrPresenciaService {

    void tiposHoras(@Valid final ProcesoDto proceso, @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void presenciaDetalleEmpleado(@Valid final ProcesoDto proceso, @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void presenciaTotalizadaTienda(@Valid final ProcesoDto proceso, @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}