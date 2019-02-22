package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

public interface ProcesoRecolectarMeta4IcmWsCalcIncomeService {

    void tiendasHistorico(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void tiendasEmpleadoHistorico(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void condicionesEmpleados(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void empleadosTienda(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void tiendasPresencia(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

    void tiendasComisionable(@Valid final ProcesoDto proceso,
            @Valid final RunProcesoRecolectarBloqueDto runProcesoRecolectarBloque);

}