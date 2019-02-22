package com.inditex.rrhh.icmclcwb.api.app.proceso.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaDto;

public interface ProcesoTiendaService {

    List<ProcesoTiendaDto> findByProceso(@Valid @NotNull final ProcesoDto proceso);

    List<ProcesoTiendaDto> createProcesoTienda(@Valid @NotNull final ProcesoDto proceso,
            @NotNull final List<ProcesoTiendaDto> procesoTienda);

}
